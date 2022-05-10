package com.example.eroto.models

import androidx.lifecycle.LiveData
import com.example.eroto.Helper
import com.github.mikephil.charting.data.Entry
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class GraphLiveData() : LiveData<List<Entry>>() {
    var databaseReference = Helper.getLoggedInUserGraphDataDatabaseReference()
    var doubleValues = ArrayList<Double>()

    init {
        doubleValues = ArrayList()
    }

    private var listener = object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            val list = ArrayList<Entry>()
            doubleValues = ArrayList()
            for (child in p0.children) {
                val double = child.getValue(Double::class.java)
                double?.let {
                    doubleValues.add(it)
                    list.add(Entry(list.size.toFloat(), it.toFloat()))
                }
            }
            value = list
        }

        override fun onCancelled(p0: DatabaseError) {}
    }

    override fun onActive() {
        super.onActive()
        databaseReference.addValueEventListener(listener)
    }

    override fun onInactive() {
        super.onInactive()
        databaseReference.removeEventListener(listener)
    }
}