package com.example.roomsample

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by PR72510 on 5/5/20.
 */
class RoomSample: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }
}