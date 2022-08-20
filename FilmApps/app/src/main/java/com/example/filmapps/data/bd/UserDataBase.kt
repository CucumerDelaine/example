package com.example.filmapps.data.bd


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.feature.regAndAuth.data.model.UserData
import com.example.filmapps.feature.characterListAndDetails.data.bd.CharacterListDAO
import com.example.filmapps.feature.regAndAuth.data.bd.UserDataDAO

@Database(entities = [UserData::class, Character::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDataDao(): UserDataDAO
    abstract fun characterListDao(): CharacterListDAO
}
