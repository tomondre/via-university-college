package com.example.eroto.models

import com.github.mikephil.charting.data.BarEntry


class BigMoverList {
    constructor(entries: ArrayList<BigMover>){
        items = entries
    }

    var items: List<BigMover> = ArrayList<BigMover>()

    fun toEntries(): List<BarEntry> {
        var temp = ArrayList<BarEntry>()
        for (i in items.indices){
            temp.add(BarEntry(i.toFloat(), items[i].value))
        }

        return temp
    }
}