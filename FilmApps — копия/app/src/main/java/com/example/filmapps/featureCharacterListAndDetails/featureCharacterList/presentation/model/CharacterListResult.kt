package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model

import com.example.core_db_api.model.Character

sealed class CharacterListResult {
    class Success(val value: List<Character?>) : CharacterListResult()
    class Error(val message: Exception) : CharacterListResult()
    object Loading : CharacterListResult()
    object Finally : CharacterListResult()
}
