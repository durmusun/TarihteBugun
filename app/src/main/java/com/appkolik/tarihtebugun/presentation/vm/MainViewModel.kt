package com.appkolik.tarihtebugun.presentation.vm

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appkolik.tarihtebugun.domain.use_case.GetAllHistoryUseCase
import com.appkolik.tarihtebugun.util.HistoryState
import com.appkolik.tarihtebugun.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllHistoryUseCase: GetAllHistoryUseCase
) : ViewModel() {

    private val _historyState  = mutableStateOf(HistoryState())
    val historyState : State<HistoryState> = _historyState

    init {
        getAllHistory()
    }

    private fun getAllHistory() {
        getAllHistoryUseCase().onEach { response ->
            when(response){
                is Resource.Success -> {
                    _historyState.value = HistoryState(
                        data = response.data?.history!! ,
                        message = response.message ?: ""
                    )
                }
                is Resource.Loading -> {
                    _historyState.value = HistoryState(
                        message = response.message.toString(),
                        loading = true
                    )
                }
                is Resource.Error -> {
                    _historyState.value = HistoryState(
                        message = response.message.toString()
                    )
                }
            }

        }.launchIn(viewModelScope)
    }

}