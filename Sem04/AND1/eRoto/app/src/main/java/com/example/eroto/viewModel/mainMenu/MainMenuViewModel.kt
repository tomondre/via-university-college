package com.example.eroto.viewModel.mainMenu

import androidx.lifecycle.LiveData
import com.example.eroto.models.User
import com.google.firebase.auth.FirebaseUser

interface MainMenuViewModel {
    fun getLoggedInUser(): LiveData<FirebaseUser>
}