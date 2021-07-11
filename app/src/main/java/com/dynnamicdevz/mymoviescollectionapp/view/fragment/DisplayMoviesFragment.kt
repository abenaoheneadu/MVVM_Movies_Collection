package com.dynnamicdevz.mymoviescollectionapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dynnamicdevz.mymoviescollectionapp.databinding.DisplayMoviesFragmentBinding
import com.dynnamicdevz.mymoviescollectionapp.view.adapter.MoviesAdapter
import com.dynnamicdevz.mymoviescollectionapp.viewmodel.MoviesViewModel


class DisplayMoviesFragment:Fragment() {
    private lateinit var binding: DisplayMoviesFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DisplayMoviesFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }
    private val viewModel: MoviesViewModel by viewModels()
    private val adapter = MoviesAdapter()
    //var manager = LinearLayoutManager(this.context)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.movieRecyclerview.layoutManager = manager
        binding.movieRecyclerview.adapter = adapter
        viewModel.moviesLiveData.observe(viewLifecycleOwner, {
            adapter.list = it
        })
        viewModel.getAllPopularMovies()

    }

    // do you see this

//    fun updateTeams(list: List<Team>){
//        adapter.list = list
//    }
}