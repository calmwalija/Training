package org.apphatchery.training.domain.repository

import org.apphatchery.training.data.local.comment.CommentRepositoryImpl
import org.apphatchery.training.data.local.message.MessageRepositoryImpl

data class BaseRepo(
    val p0: CommentRepositoryImpl,
    val p1: MessageRepositoryImpl
)
