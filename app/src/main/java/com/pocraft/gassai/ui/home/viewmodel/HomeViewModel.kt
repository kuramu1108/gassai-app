package com.pocraft.gassai.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pocraft.gassai.db.PostRepository
import com.pocraft.gassai.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postRepository: PostRepository
): ViewModel() {
    private val _posts = MutableLiveData<List<Post>>().apply {
        value = listOf()
    }
    val posts: LiveData<List<Post>> = _posts

    fun refresh() {
        viewModelScope.launch {
            postRepository.syncRemote()
        }
    }

    init {
        viewModelScope.launch {
            launch {
                postRepository
                    .posts()
                    .collect {
                        _posts.value = it
                    }
            }

            launch {
                refresh()
            }
        }
    }
}