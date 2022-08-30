package com.example.filmapps.featureAuthRegApi.data.repository

import com.example.filmapps.featureRegAndAuth.domain.model.UserDataParam

interface UserRepositories {

    fun save(userParam: UserDataParam)

    fun isUserRegistered(userParam: UserDataParam) : Boolean
}