package com.dynnamicdevz.mymoviescollectionapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dynnamicdevz.mymoviescollectionapp.R
import com.dynnamicdevz.mymoviescollectionapp.view.fragment.DisplayMoviesFragment

class MainActivity : AppCompatActivity() {
    private lateinit var displayMoviesFragment: DisplayMoviesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayMoviesFragment = supportFragmentManager.findFragmentById(R.id.display_movies_fragment) as DisplayMoviesFragment
    }
}