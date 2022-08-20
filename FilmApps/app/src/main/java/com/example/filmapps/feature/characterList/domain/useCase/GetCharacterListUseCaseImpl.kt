package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.data.repository.CacheRepository
import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListResponse
import javax.inject.Inject

class GetCharacterListUseCaseImpl @Inject constructor(
    private val cacheRepository: CacheRepository
) : GetCharacterListUseCase {
    override suspend fun execute(): GetCharacterListResponse {
        return cacheRepository.getCharacterList()
    }
}