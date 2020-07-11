package com.pocraft.gassai.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pocraft.gassai.model.Team
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Query("SELECT * FROM team")
    fun allTeams(): List<Team>

    @Query("SELECT * FROM team")
    fun allTeamsFlow(): Flow<List<Team>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teams: List<Team>)
}