package com.themovie.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.themovie.assignment.R
import com.themovie.assignment.model.MovieItems
import kotlinx.android.synthetic.main.home_item.view.*


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.HomeViewHolder>() {

        private var movieItems: List<MovieItems> = ArrayList()

        class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(mitem: MovieItems) {
               itemView.movieName.text=mitem.title



            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
            var view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_item, parent, false)
            return HomeViewHolder(view)
        }

        override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
            holder.bind(movieItems[position])
        }

        override fun getItemCount(): Int {
            return movieItems.size
        }


        fun updateMovie(movielsit: List<MovieItems>) {
            this.movieItems = movielsit
            notifyDataSetChanged()
        }

    }
