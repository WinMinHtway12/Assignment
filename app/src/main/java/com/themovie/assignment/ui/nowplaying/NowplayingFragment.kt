package com.themovie.assignment.ui.nowplaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.themovie.assignment.R

class NowplayingFragment : Fragment() {

    private lateinit var nowplayingViewModel: NowplayingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        nowplayingViewModel =
                ViewModelProvider(this).get(NowplayingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_nowplaying, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        nowplayingViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}