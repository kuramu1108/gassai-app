package com.pocraft.gassai.api

import com.pocraft.gassai.api.response.PostResponse
import com.pocraft.gassai.api.response.TeamResponse
import com.pocraft.gassai.di.ApiEndpoint
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.ContentType
import kotlinx.coroutines.Deferred
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import javax.inject.Inject

class KtorGassaiApi @Inject constructor(
    private val httpClient: HttpClient,
    @ApiEndpoint private val apiEndpoint: String
): GassaiApi {
    private val json = Json(JsonConfiguration.Stable.copy())
    override suspend fun getPosts(): List<PostResponse> {
        val rawResponse = httpClient.get<String> {
            url("$apiEndpoint/posts/all/")
            accept(ContentType.Application.Json)
        }
        return json.parse(PostResponse.serializer().list, rawResponse)
    }

    override fun getPostsAsync(): Deferred<PostResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getTeams(): List<TeamResponse> {
        val rawResponse = httpClient.get<String> {
            url("$apiEndpoint/teams/all")
            accept(ContentType.Application.Json)
        }
        return json.parse(TeamResponse.serializer().list, rawResponse)
    }
}