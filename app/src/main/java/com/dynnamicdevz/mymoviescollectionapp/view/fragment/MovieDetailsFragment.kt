package com.dynnamicdevz.mymoviescollectionapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynnamicdevz.mymoviescollectionapp.databinding.MovieDetailsFragmentLayoutBinding
import com.dynnamicdevz.mymoviescollectionapp.model.data.Result
import com.dynnamicdevz.mymoviescollectionapp.util.Constants
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.Companion.IMAGE_URL
import com.dynnamicdevz.mymoviescollectionapp.viewmodel.MoviesViewModel

class MovieDetailsFragment: Fragment() {
    companion object{
        lateinit var movieDetailsFragment: MovieDetailsFragment
        const val RESULT_KEY = "RESULT"

        fun getInstance(result:Result): MovieDetailsFragment{
            if(!this::movieDetailsFragment.isInitialized)// checking if lateinit property has been initialized
                movieDetailsFragment = MovieDetailsFragment()

            return movieDetailsFragment.also {
                it.arguments = Bundle().also { bnd ->
                    bnd.putParcelable(RESULT_KEY, result)
                }
            }
        }

    }

    private val viewModel: MoviesViewModel by activityViewModels()


    private lateinit var binding: MovieDetailsFragmentLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieDetailsFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Result>(RESULT_KEY)?.let {

            Glide.with(view)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load("$IMAGE_URL${it.poster_path}")
                .into(binding.imageView)
            binding.synopsisTv.text = it.overview
            binding.movieTitleTv.text = it.title
            binding.releaseYearTv.text = it.release_date
            binding.votesTv.text = it.vote_average.toString()
            binding.ratingBar.rating = it.vote_average.toFloat()
            //binding.runtimeTv.text = it.

            binding.addFavoriteButton.setOnClickListener {v ->
                viewModel.addToFavorites(it)
            }

        }


    }

}