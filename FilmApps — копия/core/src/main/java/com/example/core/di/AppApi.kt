package com.example.core.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

interface AppApi {

    fun getRouter(): Router
    fun getContext(): Context
    fun getNavigatorHolder(): NavigatorHolder
}