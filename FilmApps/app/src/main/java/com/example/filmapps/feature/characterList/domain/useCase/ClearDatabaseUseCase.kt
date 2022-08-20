package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterListAndDetails.data.model.Character

interface ClearDatabaseUseCase {
    suspend fun execute(characterList: List<Character>?)
}