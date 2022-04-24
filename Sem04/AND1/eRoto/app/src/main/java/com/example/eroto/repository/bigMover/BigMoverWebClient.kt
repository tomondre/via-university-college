package com.example.eroto.repository.bigMover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.BigMover
import com.example.eroto.models.BigMoverList

object BigMoverWebClient {

    private final var bigMoverGraphData: MutableLiveData<List<BigMover>> = MutableLiveData<List<BigMover>>()

    init {
        var entries = ArrayList<BigMover>()
        entries.add(BigMover("AYX", "https://etoro-cdn.etorostatic.com/market-avatars/7991/150x150.png", 11.78f))
        entries.add(BigMover("CRSR", "https://etoro-cdn.etorostatic.com/market-avatars/btc/70x70.png", 9.66f))
        entries.add(BigMover("PCG", "https://etoro-cdn.etorostatic.com/market-avatars/tsla/150x150.png", 2.98f))
        entries.add(BigMover("DOYU", "https://etoro-cdn.etorostatic.com/market-avatars/aapl/150x150.png", 2.01f))
        entries.add(BigMover("BNGO", "https://etoro-cdn.etorostatic.com/market-avatars/baba/150x150.png", 1.83f))

        bigMoverGraphData.value = entries
    }

    fun getBigMoverGraphData(): LiveData<List<BigMover>> {
        return bigMoverGraphData
    }


}