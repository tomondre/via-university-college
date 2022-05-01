package com.example.eroto.repository.stock

import com.example.eroto.models.Market
import com.example.eroto.models.Stock

object StockWebClient {



    fun getStockByTicker(ticker: String): Stock {
        var list = ArrayList<Stock>()

        list.add(
            Stock(
                "AAPL",
                "Apple",
                150.0,
                10.0,
                15.00,
                Market("NSDQ", "USD", true),
                "https://etoro-cdn.etorostatic.com/market-avatars/aapl/150x150.png"
            )
        )

        list.add(
            Stock(
                "TSLA",
                "Tesla Motors",
                150.0,
                10.0,
                15.00,
                Market("NSDQ", "USD", true),
                "https://etoro-cdn.etorostatic.com/market-avatars/tsla/150x150.png",
            )
        )

        list.add(
            Stock(
                "BABA",
                "Alibaba",
                150.0,
                10.0,
                15.00,
                Market("NSDQ", "USD", true),
                "https://etoro-cdn.etorostatic.com/market-avatars/baba/150x150.png",
            )
        )

        list.add(
            Stock(
                "VOO",
                "Vanguard S&P 500 ETF",
                150.0,
                10.0,
                15.00,
                Market("NSDQ", "USD", true),
                "https://etoro-cdn.etorostatic.com/market-avatars/4238/150x150.png",
            )
        )

        list.add(
            Stock(
                "SCHD",
                "Vertex Pharmaceuticals Incorporated",
                150.0,
                10.0,
                15.00,
                Market("NSDQ", "USD", true),
                "https://etoro-cdn.etorostatic.com/market-avatars/3217/150x150.png",
            )
        )

        for (i in list) {
            if (i.ticker == ticker)
            {
                return i
            }
        }
        return list[0]
    }
}