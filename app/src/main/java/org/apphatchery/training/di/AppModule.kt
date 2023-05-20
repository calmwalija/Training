package org.apphatchery.training.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.apphatchery.training.data.local.MessageDatabase
import org.apphatchery.training.data.local.repository.RepositoryImpl
import org.apphatchery.training.data.remote.CommentsRemoteDataSource
import org.apphatchery.training.domain.repository.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun name(): String {
        return "AppHatchery --0324"
    }

    @Singleton
    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context
    ): MessageDatabase {
        return Room.databaseBuilder(context, MessageDatabase::class.java, MessageDatabase.DB_NAME)
            .build()
    }

    @Provides
    fun providesRepository(
        database: MessageDatabase,
        remoteDataSource: CommentsRemoteDataSource
    ): Repository {
        return RepositoryImpl(database,remoteDataSource)
    }

    @Singleton
    @Provides
    fun providesRetrofit(): CommentsRemoteDataSource {
        return Retrofit.Builder()
            .baseUrl(CommentsRemoteDataSource.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CommentsRemoteDataSource::class.java)
    }
}