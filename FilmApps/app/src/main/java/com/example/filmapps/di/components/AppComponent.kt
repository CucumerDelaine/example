package com.example.filmapps.di.components

import android.content.Context
import com.example.filmapps.feature.characterListAndDetails.data.bd.CharacterListDAO
import com.example.filmapps.feature.regAndAuth.data.bd.UserDataDAO
import com.example.filmapps.di.module.ContextModule
import com.example.filmapps.di.module.DatabaseModule
import com.example.filmapps.di.module.NavigationModule
import com.example.filmapps.di.module.NetworkModule
import com.example.filmapps.presentation.ui.MainActivity
import com.github.terrakok.cicerone.Router
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [ContextModule::class, NavigationModule::class, DatabaseModule::class, NetworkModule::class])
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)

    fun getRouter(): Router
    fun getContext(): Context
    fun getDatabase(): UserDataDAO
    fun getRetrofit(): Retrofit
    fun getCharacterDatabase(): CharacterListDAO
}