package com.example.filmapps.feature.characterListAndDetails.data.bd

import androidx.room.*
import com.example.filmapps.feature.characterListAndDetails.data.model.Character


@Dao
interface CharacterListDAO {

    @Query("SELECT * FROM Character")
    fun getAll(): List<Character>?

    @Query("SELECT * FROM Character WHERE id = :id")
    fun getById(id: Int): Character?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(aCharacter: List<Character>?)

    @Delete
    fun delete(aCharacter: List<Character>?)
}