package org.apphatchery.training.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MessageDao {

    @Upsert
    suspend fun upsert(message: MessageEntity)

    @Delete
    suspend fun delete(message: MessageEntity)

    @Query("SELECT * FROM MessageEntity")
    suspend fun query(): List<MessageEntity>


}