package com.example.filmapps.featureCharacterListAndDetails.featureDetails.di.components

import com.example.core.di.AppApi
import com.example.core_db_api.di.CoreDbApi
import com.example.filmapps.app.presentation.viewModel.ViewModelFactory
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.di.module.DetailsModule
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.di.scope.DetailsScope
import dagger.Component


@Component(modules = [DetailsModule::class],
    dependencies = [CoreDbApi::class, AppApi::class])
@DetailsScope
interface DetailsComponent {
    fun viewModelsFactory(): ViewModelFactory
}