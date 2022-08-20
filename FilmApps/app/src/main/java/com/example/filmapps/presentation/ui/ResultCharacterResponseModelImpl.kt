package com.example.filmapps.presentation.ui

import android.content.Context
import com.example.filmapps.R
import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.presentation.model.CharacterDetailsUIModel
import javax.inject.Inject

class ResultCharacterResponseModelImpl @Inject constructor(
    private val context: Context
): ResultCharacterResponseModel {
    override fun converter(values: Character?): CharacterDetailsUIModel = CharacterDetailsUIModel(
        "${context.getString(R.string.name)} ${values?.name}",
        "${context.getString(R.string.status)} ${values?.status}",
        "${context.getString(R.string.species)} ${values?.species}",
        "${context.getString(R.string.gender)} ${values?.gender}",
        "${context.getString(R.string.origin)} ${values?.origin}",
        "${context.getString(R.string.location)} ${values?.location}",
        values?.image
    )
}