package com.example.eroto.models

import androidx.lifecycle.LiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class MarketDataListLiveData(reference: DatabaseReference) : LiveData<List<MarketData>>() {
    private var listener = object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            var marketList = ArrayList<MarketData>()

            for (child in p0.children) {
                child.getValue(MarketData::class.java)?.let { marketList.add(it) }
            }

            value = marketList
        }

        override fun onCancelled(p0: DatabaseError) {}
    }

    private var databaseReference: DatabaseReference = reference

    override fun onActive() {
        super.onActive()
        databaseReference.addValueEventListener(listener)
    }

    override fun onInactive() {
        super.onInactive()
        databaseReference.removeEventListener(listener)
    }
}