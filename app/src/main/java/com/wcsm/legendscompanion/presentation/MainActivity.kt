package com.wcsm.legendscompanion.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme
import com.wcsm.legendscompanion.domain.model.BaseFlowViewModel
import com.wcsm.legendscompanion.domain.model.BaseResponse
import com.wcsm.legendscompanion.domain.repository.ChampionRepository
import com.wcsm.legendscompanion.presentation.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LegendsCompanionTheme {
                AppNavigation() // Uso Real
                //TestScreen() // Uso de Teste
            }
        }
    }
}

@Composable
fun TestScreen(
    viewModel: TestViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = { viewModel.fetchChampions() }) {
            Text("FAZER REQUEST")
        }

        Spacer(Modifier.height(32.dp))

        when {
            uiState.isLoading -> Text("Carregando...")

            uiState.error != null -> Text("Erro: ${uiState.error}")

            uiState.result.isNotEmpty() -> Text(uiState.result)
        }
    }
}

data class TestUiState(
    val isLoading: Boolean = false,
    val result: String = "",
    val error: String? = null
)

sealed interface TestState

@HiltViewModel
class TestViewModel @Inject constructor(
    private val repository: ChampionRepository
) : BaseFlowViewModel<TestState, TestUiState>(TestUiState()) {

    fun fetchChampions() {
        viewModelScope.launch {

            _uiState.value = uiState.value.copy(isLoading = true)

            when (val response = repository.getAllChampions()) {

                is BaseResponse.Success -> {
                    _uiState.value = uiState.value.copy(
                        isLoading = false,
                        result = response.data.toString()
                    )
                }

                is BaseResponse.Error -> {
                    _uiState.value = uiState.value.copy(
                        isLoading = false,
                        error = response.errorMessage
                    )
                }

                BaseResponse.Loading -> Unit
            }
        }
    }
}