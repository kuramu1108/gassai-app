package com.pocraft.gassai.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "post")
data class Post (
    @PrimaryKey val id: Int,
    val title: String,
    val url: String,
    val date: LocalDate
)