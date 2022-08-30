package com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.model

import com.example.core_db_api.model.Character
import com.example.core_network_api.model.NetworkCharacter

interface CharacterConverter {
    fun convert(values: MutableList<NetworkCharacter>): MutableList<Character>
}