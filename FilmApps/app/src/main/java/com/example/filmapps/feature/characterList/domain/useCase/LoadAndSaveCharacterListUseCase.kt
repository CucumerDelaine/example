package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult

interface LoadAndSaveCharacterListUseCase {
    suspend fun execute(page: Int, ignoreCache: Boolean): SaveCharacterListResult
}