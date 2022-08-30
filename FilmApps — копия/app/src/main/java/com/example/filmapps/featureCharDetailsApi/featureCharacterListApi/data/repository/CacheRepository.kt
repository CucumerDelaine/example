package com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository

import com.example.core_db_api.model.Character
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.ClearDatabaseResult
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.SaveCharacterListResult

interface CacheRepository {
    suspend fun saveCharacterList(characterList: List<Character>?): SaveCharacterListResult
    suspend fun getCharacterList(): GetCharacterListResponse
    suspend fun clearDatabase(): ClearDatabaseResult
}