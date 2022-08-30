package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.model

import com.example.core_db_api.model.Character
import com.example.core_network_api.model.NetworkCharacter
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.model.CharacterConverter
import javax.inject.Inject

class CharacterConverterImpl @Inject constructor() : CharacterConverter {
    override fun convert(values: MutableList<NetworkCharacter>): MutableList<Character> {
        val list: MutableList<Character> = ArrayList()
            for (it in values) {
                list.add(
                    Character(
                        id = it.id,
                        name = it.name,
                        status = it.status,
                        species = it.species,
                        gender = it.gender,
                        origin = it.origin,
                        location = it.location,
                        image = it.image
                    )
                )
            }
        return list
    }
}
