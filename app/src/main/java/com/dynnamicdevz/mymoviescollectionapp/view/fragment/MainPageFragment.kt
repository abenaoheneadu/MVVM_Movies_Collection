package com.dynnamicdevz.mymoviescollectionapp.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dynnamicdevz.mymoviescollectionapp.databinding.DisplayMoviesFragmentBinding
import com.dynnamicdevz.mymoviescollectionapp.model.data.Result
import com.dynnamicdevz.mymoviescollectionapp.util.ViewType
import com.dynnamicdevz.mymoviescollectionapp.view.activity.MainActivity
import com.dynnamicdevz.mymoviescollectionapp.view.adapter.MoviesAdapter
import com.dynnamicdevz.mymoviescollectionapp.viewmodel.MoviesViewModel

class MainPageFragment: Fragment(), MoviesAdapter.MovieDelegate {

    private lateinit var binding: DisplayMoviesFragmentBinding
    private val viewModel by activityViewModels<MoviesViewModel>()
    private val adapter = MoviesAdapter(ViewType.HOME, this)

    private lateinit var movieSelector: MovieSelector
    override fun onAttach(context: Context) {
        super.onAttach(context)
        movieSelector = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DisplayMoviesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movieRecyclerview.adapter = adapter
        viewModel.moviesLiveData.observe(viewLifecycleOwner,{
            adapter.listAPIResults = it
        })
        viewModel.getAllPopularMovies()
    }

    override fun selectMovies(result: Result) {
        movieSelector.openMovieDetails(result)
    }
}