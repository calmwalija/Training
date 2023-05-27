package org.apphatchery.training.data.local.comment

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import org.apphatchery.training.data.local.Database
import org.apphatchery.training.data.remote.RemoteSource
import org.apphatchery.training.domain.repository.Repository
import javax.inject.Singleton


@Singleton
class CommentRepositoryImpl(
    private val db: Database,
    private val api: RemoteSource
) : Repository {

    private val dao = db.commentDao

    override suspend fun upsert(message: Any) {
        dao.upsert(listOf(message as CommentEntity))
    }

    override suspend fun delete(message: Any) {
        dao.delete(message as CommentEntity)
    }

    override fun query(): Flow<List<CommentEntity>> {
        return flow {
            if (dao.query().first().isEmpty()) {
                try {
                    dao.upsert(api.getComments())
                    emitAll(dao.query())
                } catch (e: Exception) {
                    emitAll(dao.query())
                }
            } else emitAll(dao.query())
        }
    }

}