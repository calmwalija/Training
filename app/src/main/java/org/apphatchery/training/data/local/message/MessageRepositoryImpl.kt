package org.apphatchery.training.data.local.message

import kotlinx.coroutines.flow.Flow
import org.apphatchery.training.data.local.Database
import org.apphatchery.training.data.local.message.MessageEntity
import org.apphatchery.training.domain.repository.Repository
import javax.inject.Singleton

@Singleton
class MessageRepositoryImpl(
    private val database: Database
) : Repository {

    private val dao = database.dao

    override suspend fun upsert(message: Any) {
        dao.upsert(message as MessageEntity)
    }

    override suspend fun delete(message: Any) {
        dao.delete(message as MessageEntity)
    }

    override fun query(): Flow<List<MessageEntity>> {
        return dao.query()
    }
}