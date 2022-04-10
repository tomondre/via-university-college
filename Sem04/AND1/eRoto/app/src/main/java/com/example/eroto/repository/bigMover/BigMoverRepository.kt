package com.example.eroto.repository.bigMover

import androidx.lifecycle.LiveData
import com.example.eroto.models.BigMover

interface BigMoverRepository {
    fun getBigMoverGraphData(): LiveData<List<BigMover>>
}