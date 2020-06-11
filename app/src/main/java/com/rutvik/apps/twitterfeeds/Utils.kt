package com.rutvik.apps.twitterfeeds

object Utils {

    fun getHashTag(text: String) : String {
        return if (text[0].equals("#"))
            text
        else
            ("#$text")
    }
}