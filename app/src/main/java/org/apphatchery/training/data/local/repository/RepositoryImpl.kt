package org.apphatchery.training.data.local.repository

import org.apphatchery.training.data.local.MessageDatabase
import org.apphatchery.training.data.local.MessageEntity
import org.apphatchery.training.domain.repository.Repository
import javax.inject.Singleton

@Singleton
class RepositoryImpl(
    private val database: MessageDatabase
) : Repository {

    private  val dao = database.dao

    override suspend fun upsert(message: MessageEntity) {
        dao.upsert(message)
    }

    override suspend fun delete(message: MessageEntity) {
        dao.delete(message)
    }

    override suspend fun query(): List<MessageEntity> {
        return  dao.query()
    }
}