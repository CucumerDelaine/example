package com.example.filmapps.feature.regAndAuth.data.repositories

import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam

interface UserRepositories {

    fun save(userParam: UserDataParam)

    fun isUserRegistered(userParam: UserDataParam) : Boolean
}