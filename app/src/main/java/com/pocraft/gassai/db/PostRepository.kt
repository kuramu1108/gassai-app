package com.pocraft.gassai.db

import com.pocraft.gassai.db.dao.PostDao
import kotlinx.coroutines.flow.map

class PostRepository constructor(private val postDao: PostDao) {
    fun posts() = postDao.allPostsFlow()
        .map { posts ->
            posts.sortedByDescending { it.date }
        }
}