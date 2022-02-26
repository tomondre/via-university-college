package com.example.eroto.viewModel.portfolio

import androidx.lifecycle.ViewModel
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.PortfolioItemList

class PortfolioViewModelImpl : ViewModel(), PortfolioViewModel {
    override fun getPortfolio(): PortfolioItemList {
        var list = ArrayList<PortfolioItem>()
        for (i in 0..10) {
            list.add(
                PortfolioItem(
                    "VRTX",
                    "Vertex Pharmaceuticals Incorporated",
                    "https://etoro-cdn.etorostatic.com/market-avatars/baba/150x150.png",
                    100.0,
                    15.17,
                    15.17,
                    115.17
                )
            )
        }
        return PortfolioItemList(list)
    }
}