package com.pocraft.gassai.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pocraft.gassai.model.Post
import com.pocraft.gassai.model.dummyPostList

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _posts = MutableLiveData<List<Post>>().apply {
        value = dummyPostList
    }
    val posts: LiveData<List<Post>> = _posts
}