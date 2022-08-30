package com.example.core_db_impl.di

import android.content.Context
import androidx.room.Room
import com.example.core_db_api.data.CharacterListRepository
import com.example.core_db_api.data.UserDataRepository
import com.example.core_db_impl.data.db.CharacterListDAO
import com.example.core_db_impl.data.db.UserDataBase
import com.example.core_db_impl.data.db.UserDataDAO
import com.example.core_db_impl.data.repository.CharacterListRepositoryImpl
import com.example.core_db_impl.data.repository.UserDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @CoreDbScope
    @Provides
    fun provideMyDatabase(context: Context): UserDataBase {
        return Room.databaseBuilder(context, UserDataBase::class.java, "my-db").build()
    }

    @CoreDbScope
    @Provides
    fun provideUserDao(userDataBase: UserDataBase): UserDataDAO {
        return userDataBase.userDataDao()
    }

    @CoreDbScope
    @Provides
    fun provideCharacterListDao(userDataBase: UserDataBase): CharacterListDAO {
        return userDataBase.characterListDao()
    }
}

@Module
internal interface DbModuleBinds {

    @Binds
    @CoreDbScope
    fun bindsUserDataRepository(impl: UserDataRepositoryImpl): UserDataRepository

    @Binds
    @CoreDbScope
    fun bindsCharacterListRepository(impl: CharacterListRepositoryImpl): CharacterListRepository
}