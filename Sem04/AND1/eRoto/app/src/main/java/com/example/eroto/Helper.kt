package com.example.eroto

import com.example.eroto.repository.user.UserRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.regex.Pattern

class Helper {
    companion object {
        fun validateEmailAndPassword(email: String, password: String) {
            if (email == "") {
                throw Exception("Email is mandatory!")
            } else if (!Pattern.compile(
                    "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                    Pattern.CASE_INSENSITIVE
                ).matcher(email).matches()
            ) {
                throw Exception("Email is not in a correct format!")
            }

            if (password == "") {
                throw Exception("Password is mandatory")
            } else if (!Pattern.compile(
                    "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}\$",
                    Pattern.CASE_INSENSITIVE
                ).matcher(password).matches()
            ) {
                throw Exception("Password should include: One lower case letter, One upper case letter, a number and be of length between 6 and 20.")
            }
        }

        fun getLoggedInUserReference(): DatabaseReference {
            val value = UserRepository.getLoggedInUser().value
            return FirebaseDatabase.getInstance("https://and-eroto-default-rtdb.europe-west1.firebasedatabase.app/").reference.child(
                "users"
            ).child(value!!.uid)
        }
    }
}