package com.example.eroto.viewModel.mainMenu

import androidx.lifecycle.LiveData
import com.example.eroto.models.User
import com.example.eroto.models.UserLiveData
import com.google.firebase.auth.FirebaseUser

interface MainMenuViewModel {
    fun getLoggedInUser(): UserLiveData
}