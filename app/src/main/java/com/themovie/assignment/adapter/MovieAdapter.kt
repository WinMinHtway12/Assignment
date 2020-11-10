package com.themovie.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.themovie.assignment.R
import com.themovie.assignment.model.ResultsItem
import kotlinx.android.synthetic.main.home_item.view.*


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.HomeViewHolder>() {

         var movieList: List<ResultsItem> = ArrayList()

   inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

          lateinit var movieItems: ResultsItem
            fun bind(mitem: ResultsItem) {
               itemView.movieName.text=mitem.title



            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
            var view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_item, parent, false)
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
