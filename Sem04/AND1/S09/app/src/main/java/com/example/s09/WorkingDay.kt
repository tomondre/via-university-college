package com.example.s09

class WorkingDay {
    var morning = false
    var noon = false
    var afternoon = false
    var shortcut = ""

    constructor() {}
    constructor(morning: Boolean, noon: Boolean, afterNoon: Boolean, shortcut: String) {
        this.morning = morning
        this.noon = noon
        this.afternoon = afterNoon
        this.shortcut = shortcut
    }

    override fun toString(): String {
        return "Shortcut: $shortcut, morning: $morning, noon: $noon, afternoon: $afternoon"
    }
}