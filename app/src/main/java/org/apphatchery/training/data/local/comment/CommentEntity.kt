package org.apphatchery.training.data.local.comment

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment")
data class CommentEntity(
    val body: String,
    val email: String,
    val name: String,
    val postId: Int,
    @PrimaryKey(autoGenerate = false) val id: Int,
)