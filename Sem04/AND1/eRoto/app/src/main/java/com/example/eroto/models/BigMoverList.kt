package com.example.eroto.models

import com.github.mikephil.charting.data.BarEntry


class BigMoverList {
    constructor(entries: ArrayList<BigMover>){
        items = entries
    }

    var items: List<BigMover> = ArrayList<BigMover>()
}