package com.example.eroto.repository.user

import androidx.lifecycle.LiveData
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User

class UserRepositoryImpl {

    private var webClient = UserWebClient

    fun performLogin(loginUser: LoginUser): LiveData<User> {
        return webClient.performLogin(loginUser)    }

    fun createUser(user: User): LiveData<User> {
        return webClient.createUser(user)
    }
}