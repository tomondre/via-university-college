package com.example.eroto.repository.user

import androidx.lifecycle.LiveData
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User
import com.example.eroto.models.UserLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

object UserRepository {

    private var webClient = UserWebClient

    fun performLogin(loginUser: LoginUser) {
        webClient.performLogin(loginUser)
    }

    fun getLoggedInUser(): UserLiveData {
        return webClient.loggedInUser
    }

    fun createUser(user: User) {
        webClient.createUser(user)
    }

    fun getLoginResponse(): LiveData<Task<AuthResult>> {
        return webClient.loginResponse
    }

    fun getSignUpResponse(): LiveData<Task<AuthResult>> {
        return webClient.signUpResponse
    }
}