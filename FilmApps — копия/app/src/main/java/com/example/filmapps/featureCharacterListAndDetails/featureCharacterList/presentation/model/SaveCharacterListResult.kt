package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model

sealed class SaveCharacterListResult {
    object Success : SaveCharacterListResult()
    class Error(val message: Exception) : SaveCharacterListResult()
}
