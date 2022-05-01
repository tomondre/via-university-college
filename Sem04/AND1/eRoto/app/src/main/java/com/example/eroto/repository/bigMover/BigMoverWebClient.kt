package com.example.eroto.repository.bigMover

import androidx.lifecycle.LiveData
import com.example.eroto.Helper
import com.example.eroto.models.BigMover
import com.example.eroto.models.BigMoverListLiveData
import io.grpc.LoadBalancer

object BigMoverWebClient {

    private var myRef = Helper.getBigMoverDatabaseReference()

    var bigMovers: BigMoverListLiveData = BigMoverListLiveData(myRef)
        private set
}