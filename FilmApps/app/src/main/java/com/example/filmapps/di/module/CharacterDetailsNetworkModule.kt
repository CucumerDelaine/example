package com.example.filmapps.di.module

import com.example.filmapps.data.retrofit.GetCharacterApi
import com.example.filmapps.di.scope.CharacterScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CharacterDetailsNetworkModule {

    @Provides
    @CharacterScope
    fun provideApi(retrofit: Retrofit): GetCharacterApi {
        return retrofit.create(GetCharacterApi::class.java)
    }
}