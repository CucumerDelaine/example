package com.example.core_db_api.data

import com.example.core_db_api.model.User

interface UserDataRepository {
    fun getUserData(login: String, pass: String): User?
    fun save(user: User)
}