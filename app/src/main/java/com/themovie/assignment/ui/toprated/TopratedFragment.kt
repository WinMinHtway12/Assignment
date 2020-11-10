package com.themovie.assignment.ui.toprated

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.themovie.assignment.R
import com.themovie.assignment.adapter.MovieAdapter
import com.themovie.assignment.model.ResultsItem
import com.themovie.assignment.ui.popular.PopularFragmentDirections
import com.themovie.assignment.ui.popular.PopularViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.recyclerMovie
import kotlinx.android.synthetic.main.fragment_toprated.*


class TopratedFragment : Fragment(),MovieAdapter.OnClickListener {

    lateinit var topratedViewModel: TopratedViewModel

    lateinit var movieAdapter: MovieAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toprated, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topratedViewModel = ViewModelProvider(this)
            .get(TopratedViewModel::class.java)
        movieAdapter = MovieAdapter()

        recyclertoprate.layoutManager = GridLayoutManager(context,2)
        recyclertoprate.adapter= movieAdapter



        movieAdapter.setOnClickListener(this)
        topratedViewModel.getToprated().observe(
           viewLifecycleOwner, Observer {
                movieAdapter.updateMovie(it.results as List<ResultsItem>)
           }
       )
    }

    override fun onResume() {
        super.onResume()
        topratedViewModel.loadmovie()
    }
    override fun onClick(item: ResultsItem) {
        val directions= TopratedFragmentDirections.actionNavTopratedToNavDetail(item)
        view?.findNavController()?.navigate(directions)
    }
}