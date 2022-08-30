package com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.domain.useCase

import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.ClearDatabaseResult

interface ClearDatabaseUseCase {
    suspend fun execute(): ClearDatabaseResult
}