package com.rutvik.apps.twitterfeeds.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Tweet (
    @Expose
    @SerializedName("id")
    val tweetId: String,

    @Expose
    @SerializedName("text")
    val tweetText: String,

    @Expose
    @SerializedName("created_at")
    val date: String
)