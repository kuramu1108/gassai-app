package com.pocraft.gassai.db

import com.pocraft.gassai.api.GassaiApi
import com.pocraft.gassai.db.dao.PostDao
import com.pocraft.gassai.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postDao: PostDao,
    private val gassaiApi: GassaiApi
) {
    fun posts() = postDao.allPostsFlow()
        .map { posts ->
            posts.sortedByDescending { it.date }
        }

    suspend fun syncRemote() = withContext(Dispatchers.IO) {
        val posts = gassaiApi.getPosts().map {
            it.toEntity()
        }
        postDao.deleteAll()
        postDao.insert(posts)
    }
}