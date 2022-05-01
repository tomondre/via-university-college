package com.example.eroto.helpers

import com.example.eroto.models.Market
import com.example.eroto.models.MarketData
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.Stock

class DummyDataPopulator {
    companion object {
        fun populateStockData() {
            val stocksDatabaseReference = com.example.eroto.Helper.getStocksDatabaseReference()
            var list = HashMap<String, Stock>()
            list["AAPL"] =
                Stock(
                    "AAPL",
                    "Apple",
                    150.0,
                    10.0,
                    15.00,
                    Market("NSDQ", "USD", true),
                    "https://etoro-cdn.etorostatic.com/market-avatars/aapl/150x150.png"
                )

            list["TSLA"] =
                Stock(
                    "TSLA",
                    "Tesla Motors",
                    150.0,
                    10.0,
                    15.00,
                    Market("NSDQ", "USD", true),
                    "https://etoro-cdn.etorostatic.com/market-avatars/tsla/150x150.png",
                )

            list["BABA"] =
                Stock(
                    "BABA",
                    "Alibaba",
                    150.0,
                    10.0,
                    15.00,
                    Market("NSDQ", "USD", true),
                    "https://etoro-cdn.etorostatic.com/market-avatars/baba/150x150.png",
                )

            list["VOO"] =
                Stock(
                    "VOO",
                    "Vanguard S&P 500 ETF",
                    150.0,
                    10.0,
                    15.00,
                    Market("NSDQ", "USD", true),
                    "https://etoro-cdn.etorostatic.com/market-avatars/4238/150x150.png",
                )

            list["SCHD"] =
                Stock(
                    "SCHD",
                    "Vertex Pharmaceuticals Incorporated",
                    150.0,
                    10.0,
                    15.00,
                    Market("NSDQ", "USD", true),
                    "https://etoro-cdn.etorostatic.com/market-avatars/3217/150x150.png",
                )

            stocksDatabaseReference.setValue(list)
        }

        fun populateMarketData() {
            val marketDatabaseReference = com.example.eroto.Helper.getMarketDatabaseReference()

            var markets = HashMap<String, MarketData>()
            markets["NSDQ100"] = MarketData("NSDQ100", 1222.2, 0.5)
            markets["SPY50"] = MarketData("SPY50", 1222.0, 0.5)
            markets["HLABAALA100"] = MarketData("HLABAALA100", 1222.2, 0.5)
            markets["HUN10"] = MarketData("HUN10", 122.2, 0.5)
            markets["MSCW100"] = MarketData("MSCW100", 122.2, 0.5)
            markets["HUN10"] = MarketData("HUN10", 122.2, 0.5)

            marketDatabaseReference.setValue(markets)
        }
    }
}