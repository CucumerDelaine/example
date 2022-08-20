package com.example.filmapps.presentation.model

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import java.lang.Exception

sealed class CharacterDetailsResponse {
    class Success(val value: Character?) : CharacterDetailsResponse()
    class Error(val message: Exception) : CharacterDetailsResponse()
}