package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.data.repository.CacheRepository
import com.example.filmapps.feature.characterList.data.repository.NetworkRepository
import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import javax.inject.Inject

class ClearDatabaseUseCaseImpl @Inject constructor(
    private val cacheRepository: CacheRepository
) : ClearDatabaseUseCase {
    override suspend fun execute(characterList: List<Character>?) {
        cacheRepository.clearDatabase(characterList)
    }
}