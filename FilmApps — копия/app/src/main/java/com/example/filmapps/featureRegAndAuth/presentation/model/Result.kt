package com.example.filmapps.featureRegAndAuth.presentation.model

sealed class Result {
    object Success : Result()
    class Error(val message: String) : Result()
    object Loading : Result()
}