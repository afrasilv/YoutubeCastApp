package com.example.alejandrofranco.mytestapplication.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.alejandrofranco.mytestapplication.R
import com.example.alejandrofranco.mytestapplication.model.YouTubeResponse
import com.squareup.picasso.Picasso
import kotlin.properties.Delegates

/**
 * Created by alejandro.franco on 10/1/19.
 */
class MainAdapter(items: List<YouTubeResponse.Items>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var data by Delegates.observable(items) { _, _, _ -> notifyDataSetChanged() }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.youtube_video_itemlist, parent, false)

        return MainViewHolder(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = data[position]
        holder.title.text = item.snippet.title
        holder.artist.text = item.snippet.channelTitle
        Picasso.get().load(item.snippet.thumbnails.high.url).into(holder.image)
    }

    class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image : ImageView = view.findViewById(R.id.song_image)
        val title : TextView = view.findViewById(R.id.song_title)
        val artist : TextView = view.findViewById(R.id.song_artist)
    }
}