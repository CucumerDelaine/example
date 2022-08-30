package com.example.filmapps.featureCharacterListAndDetails.featureDetails.data.repository

import com.example.core_db_api.data.CharacterListRepository
import com.example.filmapps.featureCharDetailsApi.featureDetailsApi.data.repository.GetCharacterRepository
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model.CharacterDetailsResponse
import javax.inject.Inject

class GetCharacterRepositoryImpl @Inject constructor(
    private val characterListRepository: CharacterListRepository
) : GetCharacterRepository {
    override suspend fun getCharacter(id: Int): CharacterDetailsResponse {
        return try {
            CharacterDetailsResponse.Success(characterListRepository.getCharacterById(id))
        } catch (e: Exception) {
            CharacterDetailsResponse.Error(e)
        }
    }
}