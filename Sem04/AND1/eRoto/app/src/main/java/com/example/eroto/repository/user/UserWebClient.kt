package com.example.eroto.repository.user

import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

object UserWebClient {

    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    var loggedInUser = MutableLiveData(mAuth.currentUser?.let { it })
        private set

    var loginResponse = MutableLiveData<Task<AuthResult>>()
        private set

    var signUpResponse = MutableLiveData<Task<AuthResult>>()
        private set


    fun performLogin(loginUser: LoginUser) {
        mAuth.signInWithEmailAndPassword(loginUser.email, loginUser.password)
            .addOnCompleteListener {
                loginResponse.value = it
            }
    }

    fun createUser(user: User) {
        mAuth.createUserWithEmailAndPassword(user.email, user.password).addOnCompleteListener {
            if (it.isSuccessful) {
                loggedInUser.value = it.result.user
                val userChangeRequest =
                    UserProfileChangeRequest.Builder().setDisplayName(user.userName).build()
                loggedInUser.value?.updateProfile(userChangeRequest)
            }

            signUpResponse.value = it
        }
    }
}