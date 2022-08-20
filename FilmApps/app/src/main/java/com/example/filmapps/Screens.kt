package com.example.filmapps

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.feature.regAndAuth.authorization.presentation.ui.AuthorizationFragment
import com.example.filmapps.feature.regAndAuth.registrations.presentation.ui.RegistrationFragment
import com.example.filmapps.feature.characterList.presentation.ui.CharacterListFragment
import com.example.filmapps.presentation.ui.DetailsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun RegistrationScreen() = FragmentScreen { RegistrationFragment() }
    fun AuthorizationScreen() = FragmentScreen { AuthorizationFragment() }
    fun ListFilmScreen() = FragmentScreen { CharacterListFragment() }
    fun Details(character: Character) = FragmentScreen { DetailsFragment(character) }
}