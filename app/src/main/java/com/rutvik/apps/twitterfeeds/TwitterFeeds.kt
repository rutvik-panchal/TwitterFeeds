package com.rutvik.apps.twitterfeeds

import android.app.Application
import com.rutvik.apps.twitterfeeds.db.TweetsDatabase

class TwitterFeeds: Application() {

    fun getTweetsDb() : TweetsDatabase {
        return TweetsDatabase.getInstance(this)
    }
}