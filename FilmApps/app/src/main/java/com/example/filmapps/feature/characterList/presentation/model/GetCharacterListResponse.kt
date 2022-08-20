package com.example.filmapps.feature.characterList.presentation.model


import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import java.lang.Exception

sealed class GetCharacterListResponse {
    class Success(val value: List<Character>?) : GetCharacterListResponse()
    class Error(val message: Exception) : GetCharacterListResponse()
}
