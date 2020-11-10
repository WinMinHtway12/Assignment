
package com.themovie.assignment.ui.popular
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
import com.themovie.assignment.adapter.MovieAdapter
import com.themovie.assignment.adapter.PopularAdapter
import com.themovie.assignment.model.ResultsItem
import kotlinx.android.synthetic.main.fragment_popular.*


class PopularFragment : Fragment() {

    lateinit var homeViewModel: PopularViewModel
    lateinit var popularAdapter: PopularAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this)
            .get(PopularViewModel::class.java)

        popularAdapter = PopularAdapter();

        recylerPopular.layoutManager =GridLayoutManager(context,2)
        recylerPopular.adapter = popularAdapter
        homeViewModel.loadmovie()

        homeViewModel.getallmovie().observe(
            viewLifecycleOwner, Observer {
                popularAdapter.updateMovie(it.results as List<ResultsItem>)
            }
        )
    }
}


