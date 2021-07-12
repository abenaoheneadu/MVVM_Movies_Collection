package com.dynnamicdevz.mymoviescollectionapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import com.dynnamicdevz.mymoviescollectionapp.R
import com.dynnamicdevz.mymoviescollectionapp.databinding.ActivityMainBinding
import com.dynnamicdevz.mymoviescollectionapp.model.data.Result
import com.dynnamicdevz.mymoviescollectionapp.view.adapter.HomeFragmentAdapter
import com.dynnamicdevz.mymoviescollectionapp.view.fragment.MovieDetailsFragment
import com.dynnamicdevz.mymoviescollectionapp.view.fragment.MovieSelector
import com.dynnamicdevz.mymoviescollectionapp.viewmodel.MoviesViewModel

class MainActivity : AppCompatActivity(), MovieSelector {

    private val viewModel by viewModels<MoviesViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var homeFragmentAdapter: HomeFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        homeFragmentAdapter = HomeFragmentAdapter(supportFragmentManager)
        binding.mainVp.adapter = homeFragmentAdapter

        binding.mainVp.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                binding.mainMenu.selectedItemId = if(position == 0) R.id.home_menu_item else R.id.favorites_menu_item
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

        binding.mainMenu.setOnNavigationItemSelectedListener{

            when(it.itemId){
                R.id.home_menu_item ->{
                    binding.mainVp.currentItem = 0
                } else ->{
                binding.mainVp.currentItem = 1
                }
            }
            true
        }
    }

    override fun openMovieDetails(result: Result) {
        val fragment = MovieDetailsFragment.getInstance(result)

        Log.d("TAG_X", "odf")
        supportFragmentManager.beginTransaction()
            .add(R.id.details_frame, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }


}
    //private lateinit var displayMoviesFragment: DisplayMoviesFragment

    /*private lateinit var binding: ActivityMainBinding
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
    }*/
