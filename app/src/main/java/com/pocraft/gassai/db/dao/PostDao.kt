package com.pocraft.gassai.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pocraft.gassai.api.response.PostResponse
import com.pocraft.gassai.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM post")
    fun allPosts(): List<Post>

    @Query("SELECT * FROM post")
    fun allPostsFlow(): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(posts: List<Post>)

    @Query("DELETE FROM post")
    suspend fun deleteAll()

    @Query("SELECT COUNT(postId) FROM post")
    suspend fun rowCount(): Int
}