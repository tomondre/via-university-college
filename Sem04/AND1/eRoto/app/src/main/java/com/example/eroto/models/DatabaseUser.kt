package com.example.eroto.models

class DatabaseUser() {
    var name: String = ""
    var email: String = ""
    var image: String = ""
    var balance: Balance = Balance(0.0)
    var portfolio: PortfolioList = PortfolioList()


    constructor(user: User) : this() {
        this.name = user.name
        this.email = user.email
        this.image = user.image
    }
}