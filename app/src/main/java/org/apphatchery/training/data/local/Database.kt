package org.apphatchery.training.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import org.apphatchery.training.data.local.comment.CommentDao
import org.apphatchery.training.data.local.comment.CommentEntity
import org.apphatchery.training.data.local.message.MessageDao
import org.apphatchery.training.data.local.message.MessageEntity

@Database(
    entities = [MessageEntity::class, CommentEntity::class],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract val dao: MessageDao
    abstract val commentDao: CommentDao

    companion object{
        const val DB_NAME ="message"
    }

}