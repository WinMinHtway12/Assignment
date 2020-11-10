package com.themovie.assignment.ui.popular

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.themovie.assignment.R
import com.themovie.assignment.adapter.MovieAdapter
import com.themovie.assignment.model.ResultsItem
import com.themovie.assignment.ui.home.HomeFragmentDirections
import com.themovie.assignment.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_popular.*

class PopularFragment : Fragment(),MovieAdapter.OnClickListener {

     lateinit var popularViewModel: PopularViewModel

    lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularViewModel = ViewModelProvider(this)
            .get(PopularViewModel::class.java)
        movieAdapter = MovieAdapter()

        recyclerMovie.layoutManager =GridLayoutManager(context,2)
        recyclerMovie.adapter= movieAdapter



        movieAdapter.setOnClickListener(this)
        popularViewModel.getPopular().observe(
            viewLifecycleOwner, Observer {
                movieAdapter.updateMovie(it.results as List<ResultsItem>)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        popularViewModel.loadmovie()
    }
    override fun onClick(item: ResultsItem) {
        val directions= PopularFragmentDirections.actionNavNowplayingToNavDetail(item)
        view?.findNavController()?.navigate(directions)
    }


}