package com.example.filmapps

import android.content.Context
import com.example.core.di.AppApi
import com.example.core.di.ContextModule
import com.example.core.di.CoreComponentManager.coreComponent
import com.example.core_db_impl.di.CoreDbComponentManager
import com.example.core_network_impl.di.CoreNetworkComponentManager
import com.example.filmapps.app.di.components.*
import com.example.core.di.DaggerCoreComponent
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.components.CharacterListComponent
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.components.DaggerCharacterListComponent
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.di.components.DaggerDetailsComponent
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.di.components.DetailsComponent
import com.example.filmapps.featureRegAndAuth.featureAuthorization.di.component.AuthorizationComponent
import com.example.filmapps.featureRegAndAuth.featureAuthorization.di.component.DaggerAuthorizationComponent
import com.example.filmapps.featureRegAndAuth.featureRegistrations.di.components.DaggerRegistrationComponent
import com.example.filmapps.featureRegAndAuth.featureRegistrations.di.components.RegistrationComponent

object ComponentManager {

    lateinit var apppComponent: ApppComponent

    private var authorizationComponent: AuthorizationComponent? = null
    private var registrationComponent: RegistrationComponent? = null
    private var characterListComponent: CharacterListComponent? = null
    private var detailsComponent: DetailsComponent? = null

    fun getAppManager() {
        apppComponent = DaggerApppComponent
            .builder()
            .appApi(coreComponent)
            .build()
    }

    fun getAuthorizationComponent(): AuthorizationComponent {
        return authorizationComponent  ?: DaggerAuthorizationComponent
            .builder()
            .appApi(coreComponent)
            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
            .build()
            .also { authorizationComponent = it }
    }

    fun clearAuthorizationComponent() {
        authorizationComponent = null
    }


    fun getRegistrationComponent(): RegistrationComponent {
        return registrationComponent  ?: DaggerRegistrationComponent
            .builder()
            .appApi(coreComponent)
            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
            .build()
            .also { registrationComponent = it }
    }

    fun clearRegistrationComponent() {
        registrationComponent = null
    }

    fun getCharacterListComponent(): CharacterListComponent {
        return characterListComponent  ?: DaggerCharacterListComponent
            .builder()
            .appApi(coreComponent)
            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
            .coreNetworkApi(CoreNetworkComponentManager.getNetworkComponent())
            .build()
            .also { characterListComponent = it }
    }

    fun clearCharacterListComponent() {
        characterListComponent = null
    }

    fun getDetailsComponent(): DetailsComponent {
        return detailsComponent  ?: DaggerDetailsComponent
            .builder()
            .appApi(coreComponent)
            .coreDbApi(CoreDbComponentManager.getCoreDbComponent())
            .build()
            .also { detailsComponent = it }
    }

    fun clearDetailsComponent() {
        detailsComponent = null
    }
}