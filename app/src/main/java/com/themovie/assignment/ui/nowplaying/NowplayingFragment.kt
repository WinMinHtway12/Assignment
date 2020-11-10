package com.themovie.assignment.ui.nowplaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.themovie.assignment.R
import com.themovie.assignment.adapter.NowPlayingAdapter

import com.themovie.assignment.model.ResultsItem

import kotlinx.android.synthetic.main.fragment_nowplaying.*


class NowplayingFragment : Fragment() {


    lateinit var nowplayingViewModel: NowplayingViewModel
    lateinit var nowPlayingAdapter: NowPlayingAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nowplaying, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nowplayingViewModel = ViewModelProvider(this)
            .get(NowplayingViewModel::class.java)

        nowPlayingAdapter = NowPlayingAdapter();

        recylerNowPlaying.layoutManager = GridLayoutManager(context,2)
        recylerNowPlaying.adapter = nowPlayingAdapter
        nowplayingViewModel.loadmovie()

        nowplayingViewModel.getallmovie().observe(
            viewLifecycleOwner, Observer {
                nowPlayingAdapter.updateMovie(it.results as List<ResultsItem>)
            }
        )
    }
}