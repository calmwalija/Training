package org.apphatchery.training.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.apphatchery.training.data.local.Database
import org.apphatchery.training.data.local.comment.CommentRepositoryImpl
import org.apphatchery.training.data.local.message.MessageRepositoryImpl
import org.apphatchery.training.data.remote.RemoteSource
import org.apphatchery.training.domain.repository.BaseRepo
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
    ): Database {
        return Room.databaseBuilder(context, Database::class.java, Database.DB_NAME)
            .build()
    }

    @Provides
    fun providesRepositoryImpl(
        db: Database,
        api: RemoteSource
    ) = BaseRepo(
        CommentRepositoryImpl(db, api),
        MessageRepositoryImpl(db)
    )

    @Provides
    @Singleton
    fun providesRemoteSource(): RemoteSource =
        Retrofit.Builder()
            .baseUrl(RemoteSource.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RemoteSource::class.java)

}