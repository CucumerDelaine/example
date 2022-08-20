package com.example.filmapps.feature.characterList.data.repository

import com.example.filmapps.feature.characterList.presentation.model.LoadCharacterListResponse

interface NetworkRepository {
    suspend fun loadCharacterList(page: Int): LoadCharacterListResponse
}