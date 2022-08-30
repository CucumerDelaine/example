package com.example.core.di

import dagger.Component
import javax.inject.Singleton

@Component(modules = [ContextModule::class, NavigationModule::class ])
@Singleton
interface CoreComponent: AppApi