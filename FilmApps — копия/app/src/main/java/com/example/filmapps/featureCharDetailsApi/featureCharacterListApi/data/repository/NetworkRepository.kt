package com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository

import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.GetCharacterListNetworkResponse

interface NetworkRepository {
    suspend fun getCharacterListNetwork(page: Int): GetCharacterListNetworkResponse
}