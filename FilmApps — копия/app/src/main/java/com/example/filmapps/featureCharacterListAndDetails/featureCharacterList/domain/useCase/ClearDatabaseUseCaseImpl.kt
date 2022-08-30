package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.domain.useCase

import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository.CacheRepository
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.domain.useCase.ClearDatabaseUseCase
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.ClearDatabaseResult
import javax.inject.Inject

class ClearDatabaseUseCaseImpl @Inject constructor(
    private val cacheRepository: CacheRepository
) : ClearDatabaseUseCase {
    override suspend fun execute(): ClearDatabaseResult {
       return cacheRepository.clearDatabase()
    }
}