package com.pocraft.gassai.api

import com.pocraft.gassai.api.response.PostResponse
import com.pocraft.gassai.api.response.TeamResponse
import kotlinx.coroutines.Deferred

interface GassaiApi {
    suspend fun getPosts(): List<PostResponse>

    fun getPostsAsync(): Deferred<PostResponse>

    suspend fun getTeams(): List<TeamResponse>
}