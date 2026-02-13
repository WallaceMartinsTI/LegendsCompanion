package com.wcsm.core.domain.model

sealed class BaseResponse<out T> {
    data object Loading : BaseResponse<Nothing>()

    data class Success<out T>(
        val data: T
    ) : BaseResponse<T>()

    data class Error(
        val errorMessage: String
    ) : BaseResponse<Nothing>()
}