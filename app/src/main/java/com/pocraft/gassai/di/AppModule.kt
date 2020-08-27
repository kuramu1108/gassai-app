package com.pocraft.gassai.di

import android.content.Context
import androidx.room.Room
import com.pocraft.gassai.api.GassaiApi
import com.pocraft.gassai.api.KtorGassaiApi
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
import io.ktor.client.HttpClient
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class ApiEndpoint

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
            "gassai.db")
            .fallbackToDestructiveMigration()
            .build()
}

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideTeamRepository(teamDao: TeamDao, gassaiApi: GassaiApi): TeamRepository =
        TeamRepository(teamDao, gassaiApi)

    @Singleton
    @Provides
    fun provideSessionRepository(sessionDao: SessionDao): SessionRepository =
        SessionRepository(sessionDao)

    @Singleton
    @Provides
    fun providePostRepository(postDao: PostDao, gassaiApi: GassaiApi): PostRepository =
        PostRepository(postDao, gassaiApi)
}

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideGassaiApi(httpClient: HttpClient, @ApiEndpoint apiEndpoint: String): GassaiApi =
        KtorGassaiApi(httpClient, apiEndpoint)

    @Provides
    fun provideHttpClient(): HttpClient =
        HttpClient()

    @ApiEndpoint
    @Provides
    fun provideApiEndpoint() = "https://po-quick-server.herokuapp.com/api"
}