package com.themovie.assignment.ui.nowplaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.themovie.assignment.R
import com.themovie.assignment.adapter.MovieAdapter
import com.themovie.assignment.model.ResultsItem
import com.themovie.assignment.ui.toprated.TopratedFragmentDirections
import com.themovie.assignment.ui.toprated.TopratedViewModel
import kotlinx.android.synthetic.main.fragment_nowplaying.*
import kotlinx.android.synthetic.main.fragment_toprated.*

class NowplayingFragment : Fragment() ,MovieAdapter.OnClickListener{

    private lateinit var nowplayingViewModel: NowplayingViewModel
    lateinit var movieAdapter: MovieAdapter
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        nowplayingViewModel =
                ViewModelProvider(this).get(NowplayingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_nowplaying, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nowplayingViewModel = ViewModelProvider(this)
            .get(NowplayingViewModel::class.java)
        movieAdapter = MovieAdapter()

        recyclernowplaying.layoutManager = GridLayoutManager(context,2)
        recyclernowplaying.adapter= movieAdapter



        movieAdapter.setOnClickListener(this)
        nowplayingViewModel.getNowplaying().observe(
            viewLifecycleOwner, Observer {
                movieAdapter.updateMovie(it.results as List<ResultsItem>)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        nowplayingViewModel.loadmovie()
    }
    override fun onClick(item: ResultsItem) {
        val directions= NowplayingFragmentDirections.actionNavPopularToNavDetail(item)
        view?.findNavController()?.navigate(directions)
    }

}