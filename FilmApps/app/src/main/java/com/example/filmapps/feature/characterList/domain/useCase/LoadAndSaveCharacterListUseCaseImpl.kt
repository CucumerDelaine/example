package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.data.repository.CacheRepository
import com.example.filmapps.feature.characterList.data.repository.NetworkRepository
import com.example.filmapps.feature.characterList.presentation.model.LoadCharacterListResponse
import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult
import javax.inject.Inject

class LoadAndSaveCharacterListUseCaseImpl @Inject constructor(
    private val cacheRepository: CacheRepository,
    private val networkRepository: NetworkRepository
) : LoadAndSaveCharacterListUseCase {
    override suspend fun execute(page: Int, ignoreCache: Boolean): SaveCharacterListResult {
        if(ignoreCache){
           return when(val loadResult = networkRepository.loadCharacterList(page)) {
                is LoadCharacterListResponse.Success -> {
                    when (val saveResult = cacheRepository.saveCharacterList(loadResult.value)) {
                        is SaveCharacterListResult.Success -> SaveCharacterListResult.Success
                        is SaveCharacterListResult.Error -> SaveCharacterListResult.Error(saveResult.message)
                    }
                }
                is LoadCharacterListResponse.Error -> SaveCharacterListResult.Error(loadResult.message)
            }
        }
        return SaveCharacterListResult.Success
    }
}