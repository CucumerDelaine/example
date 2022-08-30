package com.example.filmapps.featureCharDetailsApi.featureDetailsApi.domain.useCase

import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model.CharacterDetailsResponse

interface GetCharacterDetailsUseCase {
    suspend fun execute(id: Int): CharacterDetailsResponse
}