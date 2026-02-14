package com.wcsm.champions.presentation.ui.viewmodels

import androidx.lifecycle.viewModelScope
import com.wcsm.champions.domain.model.Champion
import com.wcsm.champions.domain.usecase.GetAllChampionsUseCase
import com.wcsm.core.domain.model.BaseFlowViewModel
import com.wcsm.core.domain.model.BaseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ChampionSummaryUiState(
    val isLoading: Boolean = false,
    val champion: Champion? = null,
    val error: String? = null
)

data class ChampionUiState(
    val isLoading: Boolean = false,
    val champions: List<Champion> = emptyList(),
    val error: String? = null
)

sealed interface ChampionState

@HiltViewModel
class ChampionViewModel @Inject constructor(
    private val getAllChampionUseCase: GetAllChampionsUseCase,
) : BaseFlowViewModel<ChampionState, ChampionUiState>(
    initialUiState = ChampionUiState()
) {
    private val _summaryUiState = MutableStateFlow(ChampionSummaryUiState())
    val summaryUiState: StateFlow<ChampionSummaryUiState> = _summaryUiState

    private fun onLoadingResponse() = _uiState.update { state -> state.copy(isLoading = true) }

    private fun onErrorResponse(errorMessage: String?) = _uiState.update { state -> state.copy(
        isLoading = false,
        error = errorMessage
    )}

    private fun onSuccessResponse(champions: List<Champion>) = _uiState.update { state -> state.copy(
        isLoading = false,
        champions = champions
    )}

    fun fetchChampions() {
        viewModelScope.launch {
            _uiState.value = uiState.value.copy(isLoading = true)

            getAllChampionUseCase().collectLatest { result ->
                when (result) {
                    is BaseResponse.Loading -> onLoadingResponse()

                    is BaseResponse.Error -> onErrorResponse(result.errorMessage)

                    is BaseResponse.Success -> onSuccessResponse(
                        champions = result.data
                    )
                }
            }
        }
    }

    fun getChampionSummary(championId: String) {
        viewModelScope.launch {
            _summaryUiState.update { it.copy(isLoading = true) }

            val champion = _uiState.value.champions.find { it.id == championId }

            if (champion != null) {
                _summaryUiState.update {
                    it.copy(
                        isLoading = false,
                        champion = champion
                    )
                }
            } else {
                _summaryUiState.update {
                    it.copy(
                        isLoading = false,
                        error = "Champion não encontrado"
                    )
                }
            }
        }
    }
}