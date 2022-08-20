package com.example.filmapps.feature.characterList.presentation.model

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import java.lang.Exception

sealed class LoadCharacterListResponse {
    class Success(val value: List<Character>?) : LoadCharacterListResponse()
    class Error(val message: Exception) : LoadCharacterListResponse()
}
