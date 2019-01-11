package com.example.alejandrofranco.mytestapplication

import android.app.Activity
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by alejandro.franco on 9/1/19.
 */
val Activity.app: App
    get() = application as App