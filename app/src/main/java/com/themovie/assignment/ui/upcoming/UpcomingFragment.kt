package com.themovie.assignment.ui.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.themovie.assignment.R
import com.themovie.assignment.adapter.PopularAdapter
import com.themovie.assignment.adapter.UpcomingAdapter
import com.themovie.assignment.model.ResultsItem
import com.themovie.assignment.ui.popular.PopularViewModel
import kotlinx.android.synthetic.main.fragment_popular.*
import kotlinx.android.synthetic.main.fragment_upcoming.*

class UpcomingFragment : Fragment() {

    lateinit var homeViewModel: UpcomingViewModel
    lateinit var upcomingAdapter: UpcomingAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this)
            .get(UpcomingViewModel::class.java)

        upcomingAdapter = UpcomingAdapter();

        recyclerUpcoming.layoutManager = GridLayoutManager(context,2)
        recyclerUpcoming.adapter = upcomingAdapter
        homeViewModel.loadmovie()

        homeViewModel.getallmovie().observe(
            viewLifecycleOwner, Observer {
                upcomingAdapter.updateMovie(it.results as List<ResultsItem>)
            }
        )
    }
}