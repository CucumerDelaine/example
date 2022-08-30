package com.example.filmapps

import com.example.core_db_api.model.Character
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.ui.CharacterListFragment
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.ui.DetailsFragment
import com.example.filmapps.featureRegAndAuth.featureAuthorization.presentation.ui.AuthorizationFragment
import com.example.filmapps.featureRegAndAuth.featureRegistrations.presentation.ui.RegistrationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun RegistrationScreen() = FragmentScreen { RegistrationFragment() }
    fun AuthorizationScreen() = FragmentScreen { AuthorizationFragment() }
    fun ListFilmScreen() = FragmentScreen { CharacterListFragment() }
    fun Details(character: Character) = FragmentScreen { DetailsFragment.getNewInstance(character) }
}