package com.example.mozzart_test.network.error

sealed class Error {
    data class NetworkError(val message: String) : Error()
    data class GeneralError(val message: String) : Error()
}