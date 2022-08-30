package com.example.core_db_impl.data.repository

import com.example.core_db_api.data.CharacterListRepository
import com.example.core_db_api.model.Character
import com.example.core_db_impl.data.db.CharacterListDAO
import com.example.core_db_impl.data.model.CharacterEntity
import javax.inject.Inject

class CharacterListRepositoryImpl @Inject constructor(
    private val characterListDAO: CharacterListDAO
) : CharacterListRepository {

    override fun getAllCharacterList(): List<Character?> {
        val charList = characterListDAO.getAll()
        val char: MutableList<Character?> = ArrayList()
        if (charList != null) {
            for (it in charList) {
                char.add(
                    Character(
                        it.id,
                        it.name,
                        it.status,
                        it.species,
                        it.gender,
                        it.origin,
                        it.location,
                        it.image
                    )
                )
            }
        }
        return char
    }

    override fun getCharacterById(id: Int): Character {
        val char = characterListDAO.getById(id)
        return Character(
            char?.id,
            char?.name,
            char?.status,
            char?.species,
            char?.gender,
            char?.origin,
            char?.location,
            char?.image
        )
    }

    override fun save(character: List<Character>?) {
        val list: MutableList<CharacterEntity> = ArrayList()
        if (character != null) {
            for (it in character) {
                list.add(
                    CharacterEntity(
                        it.id,
                        it.name,
                        it.status,
                        it.species,
                        it.gender,
                        it.origin,
                        it.location,
                        it.image
                    )
                )
            }
        }
        characterListDAO.insert(list)
    }

    override fun delete() {
        characterListDAO.delete(characterListDAO.getAll())
    }
}