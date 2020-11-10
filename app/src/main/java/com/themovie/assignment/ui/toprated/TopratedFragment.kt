package com.themovie.assignment.ui.toprated

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.themovie.assignment.R
import com.themovie.assignment.adapter.TopRateAdapter
import com.themovie.assignment.adapter.UpcomingAdapter
import com.themovie.assignment.model.ResultsItem
import com.themovie.assignment.ui.upcoming.UpcomingViewModel
import kotlinx.android.synthetic.main.fragment_toprated.*
import kotlinx.android.synthetic.main.fragment_upcoming.*


class TopratedFragment : Fragment() {
    lateinit var topratedViewModel: TopratedViewModel
    lateinit var topRateAdapter: TopRateAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toprated, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topratedViewModel = ViewModelProvider(this)
            .get(TopratedViewModel::class.java)

        topRateAdapter = TopRateAdapter()

        recyclerTopRate.layoutManager = GridLayoutManager(context,2)
        recyclerTopRate.adapter = topRateAdapter
        topratedViewModel.loadmovie()

        topratedViewModel.getallmovie().observe(
            viewLifecycleOwner, Observer {
                topRateAdapter.updateMovie(it.results as List<ResultsItem>)
            }
        )
    }
}