package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.repository

import com.example.core_db_api.data.CharacterListRepository
import com.example.core_db_api.model.Character
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository.CacheRepository
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.ClearDatabaseResult
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.SaveCharacterListResult
import javax.inject.Inject

class CacheRepositoryImpl @Inject constructor(
    private val characterListRepository: CharacterListRepository
) : CacheRepository {
    override suspend fun saveCharacterList(characterList: List<Character>?): SaveCharacterListResult {
        return try {
            characterListRepository.save(characterList)
            SaveCharacterListResult.Success
        } catch (e: Exception) {
            SaveCharacterListResult.Error(e)
        }
    }

    override suspend fun getCharacterList(): GetCharacterListResponse {

        return try {
            GetCharacterListResponse.Success(characterListRepository.getAllCharacterList())
        } catch (e: Exception) {
            GetCharacterListResponse.Error(e)
        }
    }

    override suspend fun clearDatabase(): ClearDatabaseResult {
        return try {
            characterListRepository.delete()
            ClearDatabaseResult.Success
        } catch (e: Exception) {
            ClearDatabaseResult.Error(e)
        }
    }
}