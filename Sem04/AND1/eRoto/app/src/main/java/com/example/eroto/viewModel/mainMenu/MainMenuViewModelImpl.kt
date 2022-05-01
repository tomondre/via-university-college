package com.example.eroto.viewModel.mainMenu

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.User
import com.example.eroto.models.UserLiveData
import com.example.eroto.repository.user.UserRepository
import com.google.firebase.auth.FirebaseUser

class MainMenuViewModelImpl: ViewModel(), MainMenuViewModel {
    private var userRepository = UserRepository

    override fun getLoggedInUser(): UserLiveData {
        return userRepository.getLoggedInUser()
    }
}