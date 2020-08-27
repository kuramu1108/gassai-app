package com.pocraft.gassai.db.dao

import androidx.room.*
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.model.TeamWithSessions
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Query("SELECT * FROM team")
    fun allTeams(): List<Team>

    @Query("SELECT * FROM team")
    fun allTeamsFlow(): Flow<List<Team>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teams: List<Team>)

    @Transaction
    @Query("SELECT * FROM team")
    fun getTeamsSessions(): List<TeamWithSessions>

    @Query("SELECT COUNT(teamId) FROM team")
    suspend fun rowCount(): Int

    @Query("DELETE FROM team")
    suspend fun deleteAll()
}