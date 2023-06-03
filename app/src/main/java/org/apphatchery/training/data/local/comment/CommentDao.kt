package org.apphatchery.training.data.local.comment

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {

    @Upsert
    suspend fun upsert(p0: List<CommentEntity>)

    @Delete
    suspend fun delete(p0: CommentEntity)

    @Query("SELECT * FROM comment")
    fun query(): Flow<List<CommentEntity>>

    @Query("SELECT * FROM comment WHERE id = :id")
    suspend fun queryItem(id: Int): CommentEntity?

}