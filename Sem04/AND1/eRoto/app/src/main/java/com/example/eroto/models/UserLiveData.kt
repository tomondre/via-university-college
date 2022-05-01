package com.example.eroto.models

import androidx.lifecycle.LiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class UserLiveData() : LiveData<User>() {
    private lateinit var databaseReference: DatabaseReference

    constructor(reference: DatabaseReference) : this() {
        databaseReference = reference
    }

    private var listener = object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            value = p0.getValue(User::class.java)
        }

        override fun onCancelled(p0: DatabaseError) {}
    }


    override fun onActive() {
        super.onActive()
        if (this::databaseReference.isInitialized) {
            databaseReference.addValueEventListener(listener)
        }
    }

    override fun onInactive() {
        super.onInactive()
        if (this::databaseReference.isInitialized){
            databaseReference.removeEventListener(listener)
        }
    }
}