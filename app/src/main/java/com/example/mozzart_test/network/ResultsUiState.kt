package com.example.mozzart_test.network

sealed class ResultsUiState<out T> {
    data object Loading : ResultsUiState<Nothing>()
    data class Success<out T>(val data: T) : ResultsUiState<T>()
    data class Error(val exception: Exception) : ResultsUiState<Nothing>()
}