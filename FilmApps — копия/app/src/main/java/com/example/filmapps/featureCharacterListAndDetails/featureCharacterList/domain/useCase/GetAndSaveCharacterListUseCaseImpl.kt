package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.domain.useCase

import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository.CacheRepository
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository.NetworkRepository
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.domain.useCase.GetAndSaveCharacterListUseCase
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.GetCharacterListNetworkResponse
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.SaveCharacterListResult
import javax.inject.Inject

class GetAndSaveCharacterListUseCaseImpl @Inject constructor(
    private val cacheRepository: CacheRepository,
    private val networkRepository: NetworkRepository
) : GetAndSaveCharacterListUseCase {
    override suspend fun execute(page: Int, ignoreCache: Boolean): GetCharacterListResponse {
        if(ignoreCache){
           return when(val loadResult = networkRepository.getCharacterListNetwork(page)) {
                is GetCharacterListNetworkResponse.Success -> {
                    when (val saveResult = cacheRepository.saveCharacterList(loadResult.value)) {
                        is SaveCharacterListResult.Success -> cacheRepository.getCharacterList()
                        is SaveCharacterListResult.Error -> GetCharacterListResponse.Error(saveResult.message)
                    }
                }
                is GetCharacterListNetworkResponse.Error -> GetCharacterListResponse.Error(loadResult.message)
            }
        }
        return cacheRepository.getCharacterList()
    }
}