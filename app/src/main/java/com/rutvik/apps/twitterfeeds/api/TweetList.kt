package com.rutvik.apps.twitterfeeds.api

import com.google.gson.annotations.SerializedName
import com.twitter.sdk.android.core.models.Tweet

data class TweetList(

    @SerializedName("statuses")
    val tweets : ArrayList<Tweet>
)