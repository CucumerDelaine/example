package com.example.filmapps.domain.useCase

import com.example.filmapps.presentation.model.CharacterDetailsResponse

interface GetCharacterDetailsUseCase {
    suspend fun execute(id: Int): CharacterDetailsResponse
}