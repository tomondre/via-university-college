package com.example.eroto.repository.bigMover

import androidx.lifecycle.LiveData
import com.example.eroto.models.BigMover
import com.example.eroto.models.BigMoverListLiveData

object BigMoverRepository {

    private var webClient = BigMoverWebClient

    fun getBigMoverGraphData(): BigMoverListLiveData {
        return webClient.bigMovers
    }
}