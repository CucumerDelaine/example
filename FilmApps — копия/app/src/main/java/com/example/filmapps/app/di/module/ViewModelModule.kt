package com.example.filmapps.app.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.filmapps.app.presentation.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}