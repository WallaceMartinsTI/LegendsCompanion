package com.wcsm.champions.presentation.ui.viewmodels

import androidx.lifecycle.viewModelScope
import com.wcsm.champions.domain.model.Champion
import com.wcsm.champions.domain.repository.ChampionRepository
import com.wcsm.champions.domain.usecase.GetAllChampionsUseCase
import com.wcsm.core.domain.model.BaseFlowViewModel
import com.wcsm.core.domain.model.BaseResponse
import com.wcsm.core.utils.UnitCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

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
}