package com.themovie.assignment.ui.nowplaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NowplayingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Now Playing Fragment"
    }
    val text: LiveData<String> = _text
}