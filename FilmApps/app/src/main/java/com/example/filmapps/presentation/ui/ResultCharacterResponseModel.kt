package com.example.filmapps.presentation.ui

import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.presentation.model.CharacterDetailsUIModel

interface ResultCharacterResponseModel {
    fun converter(values: Character?): CharacterDetailsUIModel
}