package com.example.filmapps.presentation.model

import com.example.filmapps.feature.characterListAndDetails.data.model.Character

sealed class CharacterDetailsResult {
    class Success(val value: CharacterDetailsUIModel?) : CharacterDetailsResult()
    class Error(val message: String) : CharacterDetailsResult()
    object Loading : CharacterDetailsResult()
}