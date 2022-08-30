package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.components

import com.example.core.di.AppApi
import com.example.core_db_api.di.CoreDbApi
import com.example.core_network_api.di.CoreNetworkApi
import com.example.filmapps.app.presentation.viewModel.ViewModelFactory
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.module.CharacterListModule
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.scope.CharacterListScope
import dagger.Component

@Component(
    modules = [CharacterListModule::class],
    dependencies = [CoreDbApi::class, AppApi::class, CoreNetworkApi::class]
)
@CharacterListScope
interface CharacterListComponent {
    fun viewModelsFactory(): ViewModelFactory
}
