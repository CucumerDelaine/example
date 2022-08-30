package com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model

import com.example.core_db_api.model.Character

sealed class CharacterDetailsResponse {
    class Success(val value: Character) : CharacterDetailsResponse()
    class Error(val message: Exception) : CharacterDetailsResponse()
}