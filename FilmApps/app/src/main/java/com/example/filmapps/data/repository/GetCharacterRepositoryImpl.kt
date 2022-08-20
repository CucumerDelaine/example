package com.example.filmapps.data.repository

import com.example.filmapps.feature.characterListAndDetails.data.bd.CharacterListDAO
import com.example.filmapps.presentation.model.CharacterDetailsResponse
import java.lang.Exception
import javax.inject.Inject

class GetCharacterRepositoryImpl @Inject constructor(
    private val characterListDao: CharacterListDAO
) : GetCharacterRepository {
    override suspend fun getCharacter(id: Int): CharacterDetailsResponse {
        return try {
            CharacterDetailsResponse.Success(characterListDao.getById(id))
        } catch (e: Exception) {
            CharacterDetailsResponse.Error(e)
        }
    }
}