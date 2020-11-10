package com.themovie.assignment.ui.upcoming

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
import kotlinx.android.synthetic.main.fragment_toprated.*
import kotlinx.android.synthetic.main.fragment_upcoming.*

class UpcomingFragment : Fragment(),MovieAdapter.OnClickListener {

    private lateinit var upcomingViewModel: UpcomingViewModel

    lateinit var movieAdapter: MovieAdapter
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        upcomingViewModel =
                ViewModelProvider(this).get(UpcomingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_upcoming, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        upcomingViewModel = ViewModelProvider(this)
            .get(UpcomingViewModel::class.java)
        movieAdapter = MovieAdapter()

        recyclerupcoming.layoutManager = GridLayoutManager(context,2)
        recyclerupcoming.adapter= movieAdapter



        movieAdapter.setOnClickListener(this)
        upcomingViewModel.getUpcoming().observe(
            viewLifecycleOwner, Observer {
                movieAdapter.updateMovie(it.results as List<ResultsItem>)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        upcomingViewModel.loadmovie()
    }
    override fun onClick(item: ResultsItem) {
        val directions= UpcomingFragmentDirections.actionNavUpcomingToNavDetail(item)
        view?.findNavController()?.navigate(directions)
    }

}