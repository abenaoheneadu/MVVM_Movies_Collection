package com.dynnamicdevz.mymoviescollectionapp

import android.app.Application
import com.dynnamicdevz.mymoviescollectionapp.model.db.MovieDatabase

class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        MovieDatabase.initializedDatabase(this)
    }

}