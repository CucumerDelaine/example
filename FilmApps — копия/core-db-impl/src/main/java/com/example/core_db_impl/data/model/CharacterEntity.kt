package com.example.core_db_impl.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: Int?,
    @ColumnInfo
    val name: String?,
    @ColumnInfo
    var status: String?,
    @ColumnInfo
    var species: String?,
    @ColumnInfo
    var gender: String?,
    @ColumnInfo
    var origin: String?,
    @ColumnInfo
    var location: String?,
    @ColumnInfo
    var image: String?
)
