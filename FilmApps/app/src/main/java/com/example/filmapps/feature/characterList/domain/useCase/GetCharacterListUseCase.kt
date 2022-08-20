package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListResponse

interface GetCharacterListUseCase {
    suspend fun execute(): GetCharacterListResponse
}