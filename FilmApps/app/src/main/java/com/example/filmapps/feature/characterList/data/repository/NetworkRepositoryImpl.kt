package com.example.filmapps.feature.characterList.data.repository

import com.example.filmapps.feature.characterList.data.model.CharacterConverter
import com.example.filmapps.feature.characterList.data.retrofit.GetPageApi
import com.example.filmapps.feature.characterList.presentation.model.LoadCharacterListResponse
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val retrofit: GetPageApi,
    private val characterConverter: CharacterConverter
) :NetworkRepository {
    override suspend fun loadCharacterList(page: Int): LoadCharacterListResponse {
        return try {
            LoadCharacterListResponse.Success(characterConverter.convert(retrofit.getPage(page).results))
        } catch (e: Exception) {
            LoadCharacterListResponse.Error(e)
        }
    }
}