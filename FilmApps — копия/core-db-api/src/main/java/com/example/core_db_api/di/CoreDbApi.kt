package com.example.core_db_api.di

import android.content.Context
import com.example.core_db_api.data.CharacterListRepository
import com.example.core_db_api.data.UserDataRepository

interface CoreDbApi {
    fun getUserDataDb(): UserDataRepository
    fun getCharacterListDb(): CharacterListRepository
}