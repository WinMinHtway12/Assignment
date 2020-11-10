package com.themovie.assignment.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.themovie.assignment.R
import com.themovie.assignment.adapter.MovieAdapter
import com.themovie.assignment.model.ResultsItem
import kotlinx.android.synthetic.main.fragment_home.*


  class HomeFragment : Fragment(),MovieAdapter.OnClickListener {

    lateinit var homeViewModel: HomeViewModel
    lateinit var movieAdapter: MovieAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this)
            .get(HomeViewModel::class.java)
        movieAdapter = MovieAdapter()

        recyclerMovie.layoutManager =GridLayoutManager(context,2)
        recyclerMovie.adapter= movieAdapter



        movieAdapter.setOnClickListener(this)
       homeViewModel.getallmovie().observe(
            viewLifecycleOwner, Observer {
                movieAdapter.updateMovie(it.results as List<ResultsItem>)
            }
        )
    }

      override fun onResume() {
          super.onResume()
          homeViewModel.loadmovie()
      }
    override fun onClick(item: ResultsItem) {
        val directions=HomeFragmentDirections.actionNavHomeToNavDetail(item)
        view?.findNavController()?.navigate(directions)
    }


 }


