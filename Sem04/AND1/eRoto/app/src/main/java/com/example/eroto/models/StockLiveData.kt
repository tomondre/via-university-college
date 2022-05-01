package com.example.eroto.models

import androidx.lifecycle.LiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class StockLiveData() : LiveData<Stock>() {
    private var listener = object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            value = p0.getValue(Stock::class.java)
        }

        override fun onCancelled(p0: DatabaseError) {}
    }

    lateinit var databaseReference: DatabaseReference

    constructor(reference: DatabaseReference) : this() {
        databaseReference = reference
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