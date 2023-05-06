package org.apphatchery.training.domain.repository

import kotlinx.coroutines.flow.Flow
import org.apphatchery.training.data.local.MessageEntity

interface Repository {

    suspend fun upsert(message: MessageEntity)

    suspend fun delete(message: MessageEntity)

    fun query(): Flow<List<MessageEntity>>

}