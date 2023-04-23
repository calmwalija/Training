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
import org.apphatchery.training.domain.repository.Repository
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
        database: MessageDatabase
    ): Repository {
        return RepositoryImpl(database)
    }
}