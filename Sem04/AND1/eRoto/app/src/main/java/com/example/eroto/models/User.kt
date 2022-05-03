package com.example.eroto.models

class User() {

    lateinit var uid: String
    lateinit var name: String
    lateinit var email: String
    lateinit var password: String
    lateinit var image: String
    lateinit var balance: Balance

    constructor(
        uid: String,
        name: String,
        email: String,
        password: String,
        image: String
    ) : this() {
        this.uid = uid
        this.name = name
        this.email = email
        this.password = password
        this.image = image
    }

    data class Builder(
        var uid: String = "",
        var name: String = "",
        var email: String = "",
        var password: String = "",
        var balance: Balance = Balance(),
        var image: String =
            "https://media.istockphoto.com/photos/businessman-silhouette-as-avatar-or-default-profile-picture-picture-id476085198?b=1&k=20&m=476085198&s=170667a&w=0&h=Ct4e1kIOdCOrEgvsQg4A1qeuQv944pPFORUQcaGw4oI="
    ) {
        fun uid(uid: String) = apply { this.uid = uid }
        fun name(name: String) = apply { this.name = name }
        fun email(email: String) = apply { this.email = email }
        fun password(password: String) = apply { this.password = password }
        fun image(image: String) = apply { this.image = image }
        fun balance(balance: Balance) = apply { this.balance = balance }

        fun build() = User(uid, name, email, password, image)
    }
}