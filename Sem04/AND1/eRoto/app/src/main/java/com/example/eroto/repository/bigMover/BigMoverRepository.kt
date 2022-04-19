package com.example.eroto.repository.bigMover

import androidx.lifecycle.LiveData
import com.example.eroto.models.BigMover

class BigMoverRepository {

    private var webClient = BigMoverWebClient

    fun getBigMoverGraphData(): LiveData<List<BigMover>> {
        return webClient.getBigMoverGraphData()
    }
}