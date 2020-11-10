package com.themovie.assignment.ui.detail

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.themovie.assignment.R
import com.themovie.assignment.model.ResultsItem
import kotlinx.android.synthetic.main.fragment_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment() {
    private val args:DetailFragmentArgs by navArgs()
    private lateinit var item:ResultsItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val BASEURL = "https:/image.tmdb.org/t/p/w500"
        item =args.item
        Picasso.get().load(BASEURL+item.backdropPath).into(backgroundimage)
        Picasso.get().load(BASEURL+item.posterPath).into(image)
        original_title.text=item.originalTitle
        original_language.text=item.originalLanguage
        voteaverage.text=item.voteAverage.toString()
        overviewtext.text=item.overview
        releasedate.text=item.releaseDate



    }
}