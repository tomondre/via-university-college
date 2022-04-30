package com.example.eroto.repository.user

import androidx.lifecycle.MutableLiveData
import com.example.eroto.Helper
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

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
                val createdUser = it.result.user

                createUserValuesInDb(user)

                loggedInUser.value = createdUser
            }

            signUpResponse.value = it
        }
    }

    private fun createUserValuesInDb(user: User) {
        val userReference = Helper.getLoggedInUserReference()

        userReference.child("name").setValue(user.userName)
        userReference.child("balance").setValue(0)
        userReference.child("image").setValue("https://media.istockphoto.com/photos/businessman-silhouette-as-avatar-or-default-profile-picture-picture-id476085198?b=1&k=20&m=476085198&s=170667a&w=0&h=Ct4e1kIOdCOrEgvsQg4A1qeuQv944pPFORUQcaGw4oI=")
        userReference.child("portfolio").setValue("")
        userReference.child("posts").setValue("")

    }
}