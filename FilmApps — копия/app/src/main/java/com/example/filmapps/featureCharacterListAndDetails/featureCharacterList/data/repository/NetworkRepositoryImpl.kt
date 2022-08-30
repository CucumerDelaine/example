package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.repository

import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.model.CharacterConverter
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository.NetworkRepository
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.GetCharacterListNetworkResponse
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val networkRepository: com.example.core_network_api.data.NetworkRepository,
    private val characterConverter: CharacterConverter
) : NetworkRepository {
    override suspend fun getCharacterListNetwork(page: Int): GetCharacterListNetworkResponse {
        return try {
            GetCharacterListNetworkResponse.Success(
                characterConverter.convert(
                    networkRepository.getCharacterListNetwork(
                        page
                    )
                )
            )
        } catch (e: Exception) {
            GetCharacterListNetworkResponse.Error(e)
        }
    }
}