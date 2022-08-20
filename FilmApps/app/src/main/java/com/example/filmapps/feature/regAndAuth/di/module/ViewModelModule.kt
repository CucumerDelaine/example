package com.example.filmapps.feature.regAndAuth.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}