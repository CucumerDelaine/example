package com.example.filmapps.featureCharacterListAndDetails.featureDetails.domain.useCase

import com.example.filmapps.featureCharDetailsApi.featureDetailsApi.data.repository.GetCharacterRepository
import com.example.filmapps.featureCharDetailsApi.featureDetailsApi.domain.useCase.GetCharacterDetailsUseCase
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model.CharacterDetailsResponse
import javax.inject.Inject

class GetCharacterDetailsUseCaseImpl @Inject constructor(
    private val getCharacterRepository: GetCharacterRepository
) : GetCharacterDetailsUseCase {
    override suspend fun execute(id: Int): CharacterDetailsResponse {
        return getCharacterRepository.getCharacter(id)
    }
}