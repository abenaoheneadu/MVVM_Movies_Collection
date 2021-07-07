package com.dynnamicdevz.mymoviescollectionapp.view.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.dynnamicdevz.mymoviescollectionapp.databinding.MovieItemLayoutBinding
import com.dynnamicdevz.mymoviescollectionapp.model.data.Result

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    var list: List<Result> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MovieViewHolder(val binding: MovieItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        //holder.binding.textView.text = list[position].name
        holder.binding.titleTextview.text = list[position].title
//        Glide.with(binding)
//            .load(list[position].poster_path)
//            .into<Target<Drawable>>(binding.posterImageview)

    }

    override fun getItemCount(): Int = list.size
}