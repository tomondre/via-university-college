package com.example.eroto.factories

import com.example.eroto.models.PortfolioItem

class PortfolioItemFactory {
    companion object {
        @JvmStatic
        fun generate(count: Int): List<PortfolioItem> {
            var list = ArrayList<PortfolioItem>()
            for (i in 0..count) {
                list.add(
                    PortfolioItem(
                        "VRTX",
                        "Vertex Pharmaceuticals Incorporated",
                        "https",
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