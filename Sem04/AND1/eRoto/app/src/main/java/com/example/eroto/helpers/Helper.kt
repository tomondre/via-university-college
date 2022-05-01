package com.example.eroto.helpers

import android.graphics.drawable.Drawable
import com.example.eroto.models.Market
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.Stock
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.navigation.NavigationView
import java.io.InputStream
import java.net.URL


class Helper {
    companion object {
        fun loadImageFromWebOperations(url: String?): Drawable? {
            return try {
                val stream: InputStream = URL(url).content as InputStream
                Drawable.createFromStream(stream, "dynamicImage")
            } catch (e: Exception) {
                null
            }
        }

        fun disableNavigationViewScrollbars(navigationView: NavigationView?) {
            if (navigationView != null) {
                val navigationMenuView = navigationView.getChildAt(0) as NavigationMenuView
                navigationMenuView.isVerticalScrollBarEnabled = false
            }
        }

        fun getStocks(): ArrayList<Stock> {
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

            return list
        }

        fun getPortfolioStocks(): ArrayList<PortfolioItem> {
            var list = ArrayList<PortfolioItem>()

            list.add(
                PortfolioItem(
                    Stock(
                        "AAPL",
                        "Apple",
                        150.0,
                        10.0,
                        15.00,
                        Market("NSDQ", "USD", true),
                        "https://etoro-cdn.etorostatic.com/market-avatars/aapl/150x150.png"
                    ),
                    150.0,
                    2.0
                )
            )

            list.add(
                PortfolioItem(
                    Stock(
                        "TSLA",
                        "Tesla Motors",
                        150.0,
                        10.0,
                        15.00,
                        Market("NSDQ", "USD", true),
                        "https://etoro-cdn.etorostatic.com/market-avatars/tsla/150x150.png",
                    ),
                    150.0,
                    2.0
                )
            )

            list.add(
                PortfolioItem(
                    Stock(
                        "BABA",
                        "Alibaba",
                        150.0,
                        10.0,
                        15.00,
                        Market("NSDQ", "USD", true),
                        "https://etoro-cdn.etorostatic.com/market-avatars/baba/150x150.png",
                    ),
                    150.0,
                    2.0
                )
            )

            list.add(
                PortfolioItem(
                    Stock(
                        "VOO",
                        "Vanguard S&P 500 ETF",
                        150.0,
                        10.0,
                        15.00,
                        Market("NSDQ", "USD", true),
                        "https://etoro-cdn.etorostatic.com/market-avatars/4238/150x150.png",
                    ),
                    150.0,
                    2.0
                )
            )

            list.add(
                PortfolioItem(
                    Stock(
                        "SCHD",
                        "Vertex Pharmaceuticals Incorporated",
                        150.0,
                        10.0,
                        15.00,
                        Market("NSDQ", "USD", true),
                        "https://etoro-cdn.etorostatic.com/market-avatars/3217/150x150.png",
                    ),
                    150.0,
                    2.0
                )
            )

            return list
        }
    }
}