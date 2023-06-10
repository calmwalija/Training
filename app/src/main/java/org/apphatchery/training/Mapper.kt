package org.apphatchery.training

import org.apphatchery.training.data.local.comment.CommentEntity
import org.apphatchery.training.data.local.message.MessageEntity
import org.apphatchery.training.domain.model.Comment
import org.apphatchery.training.domain.model.Message

fun MessageEntity.toMessage() = Message(
    username = username,
    message = message
)

fun CommentEntity.toComment() = Comment(body, email, name, postId, id)