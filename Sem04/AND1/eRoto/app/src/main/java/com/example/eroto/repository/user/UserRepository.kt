package com.example.eroto.repository.user

import androidx.lifecycle.LiveData
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User

interface UserRepository {
    fun performLogin(loginUser: LoginUser): LiveData<User>
    fun createUser(user: User): LiveData<User>
}