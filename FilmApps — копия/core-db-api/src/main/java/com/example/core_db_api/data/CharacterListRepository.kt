package com.example.core_db_api.data

import com.example.core_db_api.model.Character

interface CharacterListRepository {
    fun getAllCharacterList(): List<Character?>
    fun getCharacterById(id: Int): Character
    fun save(character: List<Character>?)
    fun delete()
}