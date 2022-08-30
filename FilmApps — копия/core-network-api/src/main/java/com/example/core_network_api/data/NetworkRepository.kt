package com.example.core_network_api.data

import com.example.core_network_api.model.NetworkCharacter

interface NetworkRepository {
    fun getCharacterListNetwork(page: Int): MutableList<NetworkCharacter>
}