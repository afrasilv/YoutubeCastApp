package com.example.alejandrofranco.mytestapplication.base.di

import com.example.alejandrofranco.mytestapplication.base.net.RetrofitInterface
import com.example.alejandrofranco.mytestapplication.main.MainPresenter
import com.example.alejandrofranco.mytestapplication.repository.SearchRepository
import com.example.alejandrofranco.mytestapplication.repository.SearchRepositoryImpl
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by alejandro.franco on 9/1/19.
 */

private const val BASE_URL = "https://www.googleapis.com/youtube/v3/"


val SearchModule = module(definition = {

    // presenter
    factory { MainPresenter(get())}

    single<SearchRepository>{ SearchRepositoryImpl(get()) }
})

val RetrofitModule = module {
    single { createWebService<SearchRepository>() }
}

private inline fun <T> createWebService(): RetrofitInterface {
    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(RetrofitInterface::class.java)
}


val appModules = listOf(RetrofitModule, SearchModule)