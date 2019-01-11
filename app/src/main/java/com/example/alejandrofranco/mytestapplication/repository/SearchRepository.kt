package com.example.alejandrofranco.mytestapplication.repository

import com.example.alejandrofranco.mytestapplication.base.net.RetrofitInterface
import com.example.alejandrofranco.mytestapplication.model.YouTubeResponse
import io.reactivex.Observable

interface SearchRepository {

    fun getDefault() : Observable<YouTubeResponse>

    fun searchYoutube(query: String) : Observable<YouTubeResponse>
}

class SearchRepositoryImpl(private val apiService: RetrofitInterface) : SearchRepository {

    lateinit var youtubeResponseList : ArrayList<YouTubeResponse.Items>

    override fun getDefault() : Observable<YouTubeResponse> {
        return apiService.getDefault()
    }

    override fun searchYoutube(query: String): Observable<YouTubeResponse> {
        return apiService.getSearch(query)
    }

    fun saveNewItems(result: List<YouTubeResponse.Items>) {
        if (youtubeResponseList.isEmpty()) {
            youtubeResponseList = result as ArrayList<YouTubeResponse.Items>
        } else {
            youtubeResponseList.addAll(result)
        }
    }

    fun getItems() : ArrayList<YouTubeResponse.Items> {
        return youtubeResponseList
    }
}