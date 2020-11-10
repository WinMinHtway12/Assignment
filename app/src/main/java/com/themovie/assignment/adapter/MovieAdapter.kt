package com.themovie.assignment.adapter

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.themovie.assignment.R
import com.themovie.assignment.model.ResultsItem
import kotlinx.android.synthetic.main.home_item.view.*


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.HomeViewHolder>() {

    var movielist: List<ResultsItem> = ArrayList()

    var clickListener: OnClickListener? = null

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        init {
            itemView.setOnClickListener(this)

        }

        val BASEURL = "https:/image.tmdb.org/t/p/w500"
        lateinit var item: ResultsItem

        fun bind(mitem: ResultsItem) {
            this.item = mitem
            itemView.movieName.text = mitem.title
            Picasso.get().load(BASEURL + mitem.posterPath).into(itemView.MovieImage)

        }

        override fun onClick(v: View?) {
            clickListener?.onClick(item)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(movielist[position])
    }

    override fun getItemCount(): Int {
        return movielist.size
    }


    fun updateMovie(movielsit: List<ResultsItem>) {
        this.movielist = movielsit
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onClick(item: ResultsItem)
    }

    //call interface
    fun setOnClickListener(clickListener: OnClickListener){
        this.clickListener=clickListener
    }

}

