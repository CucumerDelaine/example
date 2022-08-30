package com.example.core_db_impl.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserData (
    @ColumnInfo
    val login: String,
    @ColumnInfo
    val pass: String,
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
}
