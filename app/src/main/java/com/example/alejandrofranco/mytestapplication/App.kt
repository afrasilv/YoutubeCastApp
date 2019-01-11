package com.example.alejandrofranco.mytestapplication

import android.app.Application
import com.example.alejandrofranco.mytestapplication.base.di.appModules
import org.koin.android.ext.android.startKoin

/**
 * Created by alejandro.franco on 9/1/19.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModules)
    }
}
