package com.example.filmapps.featureCharDetailsApi.featureDetailsApi.presentation.model

import com.example.core_db_api.model.Character
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model.CharacterDetailsUIModel

interface ResultCharacterResponseModel {
    fun converter(values: Character?): CharacterDetailsUIModel
}