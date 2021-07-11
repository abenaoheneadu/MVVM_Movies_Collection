package com.dynnamicdevz.mymoviescollectionapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.dynnamicdevz.mymoviescollectionapp.R
import com.dynnamicdevz.mymoviescollectionapp.databinding.ActivityMainBinding
import com.dynnamicdevz.mymoviescollectionapp.view.adapter.MoviesAdapter
import com.dynnamicdevz.mymoviescollectionapp.view.fragment.DisplayMoviesFragment
import com.dynnamicdevz.mymoviescollectionapp.viewmodel.MoviesViewModel

class MainActivity : AppCompatActivity() {
    //private lateinit var displayMoviesFragment: DisplayMoviesFragment
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MoviesViewModel by viewModels()
    private val adapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // displayMoviesFragment = supportFragmentManager.findFragmentById(R.id.display_movies_fragment) as DisplayMoviesFragment
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.movieSortedRecyclerview.adapter = adapter
        viewModel.moviesLiveData.observe(this, {
            adapter.list = it
            Log.d("TAG_X", "Data retrieved ${it.size}")
        })
        viewModel.getAllPopularMovies()
    }
}