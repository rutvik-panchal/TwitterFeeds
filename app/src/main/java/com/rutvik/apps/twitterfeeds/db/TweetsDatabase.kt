package com.rutvik.apps.twitterfeeds.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TweetsStore::class], version = 1)
abstract class TweetsDatabase : RoomDatabase() {

    abstract fun tweetsDao(): TweetsDao

    companion object {

        lateinit var INSTANCE : TweetsDatabase

        fun getInstance(context: Context) : TweetsDatabase {
            synchronized(TweetsDatabase::class) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    TweetsDatabase::class.java, "my-tweets-store.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}