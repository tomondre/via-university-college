package com.example.eroto.models

import com.google.firebase.auth.FirebaseUser

class User() {

    var uid = ""
    var userName: String = ""
    var email: String = ""
    var password: String = ""

    constructor(userName: String, email: String, password: String): this() {
        this.email = email
        this.password = password
        this.userName = userName
    }

    constructor(user: FirebaseUser) : this() {
        this.email = user.email.toString()
        this.userName = user.displayName.toString()
        this.uid = user.uid
    }
}