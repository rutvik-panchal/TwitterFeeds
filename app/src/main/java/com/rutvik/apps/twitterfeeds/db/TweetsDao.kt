package com.rutvik.apps.twitterfeeds.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface TweetsDao {

    @Query("SELECT * from tweetsData")
    fun getAll(): List<TweetsStore>

    @Insert(onConflict = REPLACE)
    fun insert(tweets: TweetsStore)

    @Update
    fun update(tweets: TweetsStore)

    @Delete
    fun delete(tweets: TweetsStore)
}