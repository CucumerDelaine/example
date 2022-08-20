package com.example.filmapps.feature.characterList.data.repository

import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult
import com.example.filmapps.feature.characterListAndDetails.data.model.Character

interface CacheRepository {
    suspend fun saveCharacterList(characterList: List<Character>?): SaveCharacterListResult
    suspend fun getCharacterList(): GetCharacterListResponse
    suspend fun clearDatabase(characterList: List<Character>?)
}