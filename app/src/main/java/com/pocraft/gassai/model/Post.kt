package com.pocraft.gassai.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "post")
data class Post (
    @PrimaryKey val postId: Int,
    val title: String,
    val url: String,
    val date: LocalDateTime
)