package org.apphatchery.training.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MessageEntity::class],
    version = 1
)
abstract class MessageDatabase : RoomDatabase() {
    abstract val dao: MessageDao

    companion object{
        const val DB_NAME ="message"
    }

}