package com.example.eroto.repository.purchase

import com.example.eroto.Helper
import com.example.eroto.models.PortfolioItem
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

object PurchaseWebClient {


    fun purchaseStock(item: PortfolioItem) {
        val ref = Helper.getUserPortfolioReference()
        ref.addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.children
                val result = ArrayList<PortfolioItem>()
                for (dataSnapshot in value) {
                    val value1 = dataSnapshot.getValue(PortfolioItem::class.java)
                    result.add(value1!!)
                }
                result.add(item)
                ref.setValue(result)
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}