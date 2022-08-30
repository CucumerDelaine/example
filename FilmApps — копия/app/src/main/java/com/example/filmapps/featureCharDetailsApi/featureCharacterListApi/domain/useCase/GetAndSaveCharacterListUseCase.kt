package com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.domain.useCase

import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.model.GetCharacterListResponse

interface GetAndSaveCharacterListUseCase {
    suspend fun execute(page: Int, ignoreCache: Boolean = false): GetCharacterListResponse
}