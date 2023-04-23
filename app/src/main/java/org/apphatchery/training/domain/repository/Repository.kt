package org.apphatchery.training.domain.repository

import org.apphatchery.training.data.local.MessageEntity

interface Repository {

    suspend fun upsert(message: MessageEntity)

    suspend fun delete(message: MessageEntity)

    suspend fun query(): List<MessageEntity>

}