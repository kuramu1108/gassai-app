package com.pocraft.gassai.api.response

import com.pocraft.gassai.model.Post
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Serializable
data class PostResponse(
    val id: Int,
    val title: String,
    val url: String,
    val date: String
) {
    fun toEntity(): Post =
        Post(
            postId = id,
            title = title,
            url = url,
            date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay()
        )
}