package com.example.eroto

import com.example.eroto.repository.user.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.security.AuthProvider
import java.util.regex.Pattern

class Helper {
    companion object {
        var URL = "https://and-eroto-default-rtdb.europe-west1.firebasedatabase.app/"

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

        fun getLoggedInUserDatabaseReference(): DatabaseReference {
            val uid = FirebaseAuth.getInstance().currentUser?.uid
            return getUsersDatabaseReference().child(uid!!)
        }

        fun getUsersDatabaseReference(): DatabaseReference {
            return FirebaseDatabase.getInstance(URL).reference.child("users")
        }

        fun getUserPortfolioReference(): DatabaseReference {
            return getLoggedInUserDatabaseReference().child("portfolio")
        }

        fun getMarketDatabaseReference(): DatabaseReference {
            return FirebaseDatabase.getInstance(URL).reference.child("markets")
        }

        fun getStocksDatabaseReference(): DatabaseReference {
            return FirebaseDatabase.getInstance(URL).reference.child("stocks")
        }

        fun getBigMoverDatabaseReference(): DatabaseReference {
            return FirebaseDatabase.getInstance(URL).reference.child("bigMovers")
        }

        fun parseMarketInfo(marketTicker: String, currency: String): String {
            return "PRICES BY $marketTicker, IN $currency"
        }

        fun parseMarketOpen(isOpen: Boolean): String {
            var result = "MARKET "
            result += if (isOpen) "OPEN" else "CLOSED"
            return result
        }
    }
}