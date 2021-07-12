package com.dynnamicdevz.mymoviescollectionapp.view.adapter

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.dynnamicdevz.mymoviescollectionapp.databinding.MovieFavoriteLayoutBinding
import com.dynnamicdevz.mymoviescollectionapp.databinding.MovieFavoritesFragmentLayoutBinding
import com.dynnamicdevz.mymoviescollectionapp.databinding.MovieItemLayoutBinding
import com.dynnamicdevz.mymoviescollectionapp.databinding.MovieSortedItemLayoutBinding
import com.dynnamicdevz.mymoviescollectionapp.model.data.Result
import com.dynnamicdevz.mymoviescollectionapp.util.Constants.Companion.IMAGE_URL
import com.dynnamicdevz.mymoviescollectionapp.util.ViewType


class MoviesAdapter(private val vType: ViewType, private val movieDelegate: MovieDelegate) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
interface MovieDelegate{
    fun selectMovies(result: Result)
}
    inner class FavoritesViewHolder(val binding: MovieFavoriteLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class HomeViewHolder(val binding: MovieSortedItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    var listResults = listOf<Result>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (vType == ViewType.HOME) {
            HomeViewHolder(
                MovieSortedItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else
            FavoritesViewHolder(
                MovieFavoriteLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val result = listResults[position]
        if (holder is HomeViewHolder) {

            holder.binding.root.setOnClickListener {
                movieDelegate.selectMovies(result)
                Log.d("TAG_X", "clicked....")
            }

            Glide.with(holder.itemView)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load("$IMAGE_URL${listResults[position].poster_path}")
                .into(holder.binding.posterImageview)
        } else if (holder is FavoritesViewHolder) {

            holder.binding.root.setOnClickListener {
                movieDelegate.selectMovies(result)
                Log.d("TAG_X", "clicked....")
            }

            Glide.with(holder.itemView)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load("$IMAGE_URL${listResults[position].poster_path}")
                .into(holder.binding.posterImageview)
            holder.binding.titleTextview.text = result.title
        }
    }

    override fun getItemCount(): Int = listResults.size
}

/*
class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    var list: List<Result> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MovieViewHolder(val binding: MovieSortedItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieSortedItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        //holder.binding.textView.text = list[position].name
        //holder.binding.titleTextview.text = list[position].title
        Glide.with(holder.itemView)
            .load("$IMAGE_URL${list[position].poster_path}")
            .into(holder.binding.posterImageview)

        Log.d("TAG_X", "Link? ${list[position].poster_path}")
        //holder.binding.releaseYearTextview.text = list[position].release_date

    }

    override fun getItemCount(): Int = list.size
}*/