package com.example.eroto.factories

import com.example.eroto.models.PortfolioItem

class PortfolioItemFactory {
    companion object {
        fun generate(count: Int): List<PortfolioItem> {
            var list = ArrayList<PortfolioItem>()
            for (i in 0..count) {
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
            return list
        }
    }
}