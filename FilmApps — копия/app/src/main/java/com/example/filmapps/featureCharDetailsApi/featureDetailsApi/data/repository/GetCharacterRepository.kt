package com.example.filmapps.featureCharDetailsApi.featureDetailsApi.data.repository

import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model.CharacterDetailsResponse

interface GetCharacterRepository {
    suspend fun getCharacter(id: Int): CharacterDetailsResponse
}