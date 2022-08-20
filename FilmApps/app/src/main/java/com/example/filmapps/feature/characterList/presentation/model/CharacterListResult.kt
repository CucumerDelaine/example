package com.example.filmapps.feature.characterList.presentation.model

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import java.lang.Exception

sealed class CharacterListResult {
    class Success(val value: List<Character>?) : CharacterListResult()
    class Error(val message: Exception) : CharacterListResult()
    object Loading : CharacterListResult()
    object Finally : CharacterListResult()
}
