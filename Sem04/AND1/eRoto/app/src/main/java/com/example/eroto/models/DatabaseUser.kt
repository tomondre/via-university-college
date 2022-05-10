package com.example.eroto.models

import kotlin.collections.ArrayList

class DatabaseUser() {
    var name: String = ""
    var email: String = ""
    var image: String = ""
    var balance: Balance = Balance(0.0)
    var portfolio: ArrayList<PortfolioItem> = ArrayList()
    var graphData: ArrayList<Double> = ArrayList()

    constructor(user: User) : this() {
        this.name = user.name
        this.email = user.email
        this.image = user.image
    }
}