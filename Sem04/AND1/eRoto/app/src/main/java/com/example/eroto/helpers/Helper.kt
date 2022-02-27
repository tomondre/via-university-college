package com.example.eroto.helpers

import android.graphics.drawable.Drawable
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
    }
}