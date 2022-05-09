package com.example.eroto.models

import androidx.lifecycle.LiveData
import com.example.eroto.Helper
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class UserPortfolioLiveData : LiveData<List<PortfolioItem>>() {

    var databaseReference = Helper.getUserPortfolioReference()

    var stocksReference = Helper.getStocksDatabaseReference()

    private var listener = object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            value = ArrayList()
            for (child in p0.children) {
                child.getValue(PortfolioItem::class.java)?.let { item ->
                    stocksReference.child(item.stock.ticker).addValueEventListener(object :
                        ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val value = dataSnapshot.getValue(Stock::class.java)
                            value?.let { item.stock = it }
                            val arrayList = ArrayList(getValue()!!)
                            arrayList.add(item)
                            setValue(arrayList)
                        }

                        override fun onCancelled(databaseError: DatabaseError) {}
                    })

                }
            }
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