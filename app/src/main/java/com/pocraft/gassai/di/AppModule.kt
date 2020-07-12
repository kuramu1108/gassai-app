package com.pocraft.gassai.di

import android.content.Context
import androidx.room.Room
import com.pocraft.gassai.db.AppDatabase
import com.pocraft.gassai.db.PostRepository
import com.pocraft.gassai.db.SessionRepository
import com.pocraft.gassai.db.TeamRepository
import com.pocraft.gassai.db.dao.PostDao
import com.pocraft.gassai.db.dao.SessionDao
import com.pocraft.gassai.db.dao.TeamDao
import com.pocraft.gassai.db.dao.VenueDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Provides
    fun providePostDao(database: AppDatabase): PostDao = database.postDao()

    @Provides
    fun provideSessionDao(database: AppDatabase): SessionDao = database.sessionDao()

    @Provides
    fun provideTeamDao(database: AppDatabase): TeamDao = database.teamDao()

    @Provides
    fun provideVenueDao(database: AppDatabase): VenueDao = database.venueDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "gassai.db"
        ).build()
}

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideTeamRepository(teamDao: TeamDao): TeamRepository =
        TeamRepository(teamDao)

    @Singleton
    @Provides
    fun provideSessionRepository(sessionDao: SessionDao): SessionRepository =
        SessionRepository(sessionDao)

    @Singleton
    @Provides
    fun providePostRepository(postDao: PostDao): PostRepository =
        PostRepository(postDao)
}