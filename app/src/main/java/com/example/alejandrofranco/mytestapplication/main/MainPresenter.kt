package com.example.alejandrofranco.mytestapplication.main

import android.util.Log
import com.example.alejandrofranco.mytestapplication.model.YouTubeResponse
import com.example.alejandrofranco.mytestapplication.repository.SearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by alejandro.franco on 10/1/19.
 */
class MainPresenter(private val repo: SearchRepository) {

    lateinit var view: View

    fun searchVideo(query: String): Disposable? {
        return repo.searchYoutube(query)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({
                    result ->
                Log.d("Result", result.items.toString())
//                repo.saveNewItems(result.items)
                view.updateData(result.items)
            }, { error ->
                error.printStackTrace()
            })
    }

    fun getDefault(): Disposable? {
        return repo.getDefault()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({
                    result ->
                Log.d("Result", result.items.toString())
                view.updateData(result.items)
            }, { error ->
                error.printStackTrace()
            })
    }


    interface View {
        fun updateData(media: List<YouTubeResponse.Items>)
    }
}