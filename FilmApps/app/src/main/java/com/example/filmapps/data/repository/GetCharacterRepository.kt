package com.example.filmapps.data.repository

import com.example.filmapps.presentation.model.CharacterDetailsResponse

interface GetCharacterRepository {
    suspend fun getCharacter(id: Int): CharacterDetailsResponse
}