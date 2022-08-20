package com.example.filmapps.feature.characterList.data.model

import com.example.filmapps.feature.characterListAndDetails.data.model.Character

interface CharacterConverter {
    fun convert(values: ArrayList<Results>?): MutableList<Character>
}