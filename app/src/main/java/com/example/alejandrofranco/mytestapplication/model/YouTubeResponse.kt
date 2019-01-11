package com.example.alejandrofranco.mytestapplication.model

import com.google.gson.annotations.SerializedName

/**
 * Created by alejandro.franco on 8/11/18.
 */

data class YouTubeResponse(
    @SerializedName("items")
    val items : List<Items>
) {


    data class Items(
        @SerializedName("kind")
        val kind: String,
        @SerializedName("etag")
        val etag: String,
        @SerializedName("id")
        val id: YoutubeId,
        @SerializedName("snippet")
        val snippet: YouTubeSnippet
    ) {


        data class YoutubeId (
            @SerializedName("kind")
            val kind: String,
            @SerializedName("videoId")
            val videoId: String
        )

        data class YouTubeSnippet (
            @SerializedName("publishedAt")
            val publishedAt: String,
            @SerializedName("title")
            val title: String,
            @SerializedName("thumbnails")
            val thumbnails: YoutubeThumbnails,
            @SerializedName("channelTitle")
            val channelTitle: String
        ) {


            data class YoutubeThumbnails (
                @SerializedName("default")
                val default: ThumbnailsBody,
                @SerializedName("high")
                val high: ThumbnailsBody
            ) {

                data class ThumbnailsBody(
                    @SerializedName("url")
                    val url: String
                )
            }
        }
    }
}