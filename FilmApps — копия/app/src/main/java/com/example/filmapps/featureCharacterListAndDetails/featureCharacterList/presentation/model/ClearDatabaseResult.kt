package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model

sealed class ClearDatabaseResult {
    object Success : ClearDatabaseResult()
    class Error(val message: Exception) : ClearDatabaseResult()
}
