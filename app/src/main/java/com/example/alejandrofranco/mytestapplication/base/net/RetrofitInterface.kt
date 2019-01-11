package com.example.alejandrofranco.mytestapplication.base.net

import com.example.alejandrofranco.mytestapplication.model.YouTubeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("search")
    fun getDefault(@Query("q") q : String = "music", @Query("part") part : String = "snippet", @Query("type") type : String = "video", @Query("key") key: String = "AIzaSyApncGQhp6vaTbP9VdCNywB9IF0qdYwP3o", @Query("maxResults") maxResults: Int = 20) : Observable<YouTubeResponse>


    @GET("search")
    fun getSearch(@Query("q") q : String, @Query("part") part : String = "snippet", @Query("type") type : String = "video", @Query("key") key: String = "AIzaSyApncGQhp6vaTbP9VdCNywB9IF0qdYwP3o", @Query("maxResults") maxResults: Int = 20) : Observable<YouTubeResponse>
}