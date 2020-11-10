package com.themovie.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.themovie.assignment.R
import com.themovie.assignment.model.ResultsItem

import kotlinx.android.synthetic.main.home_item.view.releaseDate
import kotlinx.android.synthetic.main.popular_item.view.*

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.HomeViewHolder>() {

        var movieList: List<ResultsItem> = ArrayList()

        inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val BASEURL = "https://image.tmdb.org/t/p/w500/"
            lateinit var movieItems: ResultsItem
            fun bind(mitem: ResultsItem) {

                itemView.moviePopularName.text=mitem.title

                itemView.popularReleaseDate.text=mitem.releaseDate
                Picasso.get()
                    .load(BASEURL+mitem.posterPath)
                    .placeholder(R.drawable.camera)
                    .into(itemView.poplarImage)

            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
            var view = LayoutInflater.from(parent.context)
                .inflate(R.layout.popular_item, parent, false)
            return HomeViewHolder(view)
        }

        override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
            holder.bind(movieList[position])
        }

        override fun getItemCount(): Int {
            return movieList.size
        }


        fun updateMovie(movielsit: List<ResultsItem>) {
            this.movieList = movielsit
            notifyDataSetChanged()
        }

    }
