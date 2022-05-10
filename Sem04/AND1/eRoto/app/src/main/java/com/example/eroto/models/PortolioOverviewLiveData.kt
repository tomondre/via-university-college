package com.example.eroto.models

import androidx.lifecycle.LiveData
import com.example.eroto.Helper
import com.github.mikephil.charting.data.Entry
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class PortfolioOverviewLiveData() : LiveData<PortfolioOverview>() {
    var databaseReference = Helper.getUserPortfolioReference()
    var stocksReference = Helper.getStocksDatabaseReference()

    private var portfolioItems = ArrayList<PortfolioItem>()

    private var listener = object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            value = PortfolioOverview()
            portfolioItems = ArrayList()
            for (child in p0.children) {
                child.getValue(PortfolioItem::class.java)?.let { item ->
                    stocksReference.child(item.stock.ticker).addValueEventListener(object :
                        ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val stock = dataSnapshot.getValue(Stock::class.java)
                            stock?.let { item.stock = it }
                            portfolioItems.add(item)
                            var plPercentage = 0.0
                            var plValue = 0.0
                            var portfolioValue = 0.0
                            var currency = "$"

                            for (item in portfolioItems) {
                                portfolioValue += item.valueInvested
                                plValue += item.stock.plValue
                                plPercentage += (item.stock.plPercentage / 2)
                            }

                            value = PortfolioOverview(currency, portfolioValue, plValue, plPercentage, ArrayList())
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