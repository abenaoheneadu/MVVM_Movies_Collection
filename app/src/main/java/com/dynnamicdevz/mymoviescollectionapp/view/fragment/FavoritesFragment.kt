package com.dynnamicdevz.mymoviescollectionapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dynnamicdevz.mymoviescollectionapp.databinding.DisplayMoviesFragmentBinding
import com.dynnamicdevz.mymoviescollectionapp.databinding.MovieFavoritesFragmentLayoutBinding
import com.dynnamicdevz.mymoviescollectionapp.util.ViewType
import com.dynnamicdevz.mymoviescollectionapp.view.adapter.MoviesAdapter
import com.dynnamicdevz.mymoviescollectionapp.viewmodel.MoviesViewModel

class FavoritesFragment: Fragment() {

    private lateinit var binding: MovieFavoritesFragmentLayoutBinding
    private val viewModel by activityViewModels<MoviesViewModel>()
    private val adapter = MoviesAdapter(ViewType.FAVORITES)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieFavoritesFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movieFavoritesRecyclerview.adapter = adapter
        viewModel.moviesLiveData.observe(viewLifecycleOwner,{
            adapter.listResults = it
        })
    }

}