package com.rutvik.apps.twitterfeeds.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tweetsData")
data class TweetsStore (

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "hashtag")
    var hashTag: String = "",

    @ColumnInfo(name = "username")
    var userName: String = "",

    @ColumnInfo(name = "text")
    var text: String = "",

    @ColumnInfo(name = "createdAt")
    var createdAt: Boolean = false

)