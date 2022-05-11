package com.example.eroto.models

import androidx.lifecycle.LiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class BalanceLiveData(reference: DatabaseReference) : LiveData<Balance>() {
    private var databaseReference: DatabaseReference = reference

    private var listener = object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            value = p0.getValue(Balance::class.java)
        }

        override fun onCancelled(p0: DatabaseError) {}
    }

    init {
        databaseReference.addValueEventListener(listener)
    }
}