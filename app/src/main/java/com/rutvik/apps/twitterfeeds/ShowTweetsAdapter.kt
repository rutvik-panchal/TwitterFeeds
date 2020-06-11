package com.rutvik.apps.twitterfeeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twitter.sdk.android.core.models.Tweet

class ShowTweetsAdapter(val list: List<Tweet>): RecyclerView.Adapter<ShowTweetsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_tweets, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tweet = list[0]
        holder.userNameField.text = tweet.user.name.toString()
        holder.textField.text = tweet.text.toString()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userNameField: TextView = itemView.findViewById(R.id.user_name)
        val textField: TextView = itemView.findViewById(R.id.tweet_text)
    }
}