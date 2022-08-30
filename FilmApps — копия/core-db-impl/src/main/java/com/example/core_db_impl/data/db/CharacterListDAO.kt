package com.example.core_db_impl.data.db

import androidx.room.*
import com.example.core_db_impl.data.model.CharacterEntity


@Dao
interface CharacterListDAO {

    @Query("SELECT * FROM CharacterEntity")
    fun getAll(): List<CharacterEntity>?

    @Query("SELECT * FROM CharacterEntity WHERE id = :id")
    fun getById(id: Int): CharacterEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(aCharacter: List<CharacterEntity>?)

    @Delete
    fun delete(aCharacter: List<CharacterEntity>?)
}