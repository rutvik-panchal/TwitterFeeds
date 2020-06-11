package com.rutvik.apps.twitterfeeds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rutvik.apps.twitterfeeds.api.ApiClient
import com.rutvik.apps.twitterfeeds.api.TweetList
import com.twitter.sdk.android.core.models.Tweet
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var tweetList: ArrayList<Tweet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchTweetsButton.setOnClickListener {
            showTweets(editTextHashtag.text.toString())
        }
    }

    fun setUpTweetsAdapter() {
        val tweetsAdapter = ShowTweetsAdapter(tweetList)
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = tweetsAdapter
    }

    private fun showTweets(hashTag : String) {
        val callback = object : Callback<TweetList> {
            override fun onFailure(call: Call<TweetList>?, t:Throwable?) {
                Log.e("MainActivity", "Problem calling API {${t?.message}}")
            }

            override fun onResponse(call: Call<TweetList>?, response: Response<TweetList>?) {
                response?.isSuccessful.let {
                    Log.d("Main",response?.body().toString())
                    val list: TweetList? = response?.body()
                    tweetList = list!!.tweets
                    setUpTweetsAdapter()
                }
            }
        }
        ApiClient.retreiveTweets(callback, hashTag)
    }
}
