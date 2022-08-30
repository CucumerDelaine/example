package com.example.filmapps.app.di.components

import com.example.core.di.AppApi
import com.example.filmapps.app.presentation.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [AppApi::class])
@Singleton
interface ApppComponent {
    fun inject(activity: MainActivity)
}