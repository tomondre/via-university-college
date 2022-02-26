package com.example.eroto.helpers

import android.graphics.drawable.Drawable
import java.io.InputStream
import java.net.URL


class Helper {
    companion object {
        fun LoadImageFromWebOperations(url: String?): Drawable? {
            return try {
                val stream: InputStream = URL(url).content as InputStream
                Drawable.createFromStream(stream, "dynamicImage")
            } catch (e: Exception) {
                null
            }
        }
    }
}