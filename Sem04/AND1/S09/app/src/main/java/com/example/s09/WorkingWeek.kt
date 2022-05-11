package com.example.s09

import com.example.s09.WorkingDay

class WorkingWeek {
    var days: Array<WorkingDay>

    constructor(days: Array<WorkingDay>) {
        this.days = days
    }

    constructor() {
        days = Array(7) { WorkingDay() }
    }

    fun getDayByIndex(index: Int): WorkingDay {
        return days[index]
    }

    fun getDaysCount(): Int {
        return days.size
    }

    override fun toString(): String {
        var result = ""
        for (day in days) {
            result += day.toString() + "\n"
        }
        return result
    }
}