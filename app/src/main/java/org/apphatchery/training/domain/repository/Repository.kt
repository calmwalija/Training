package org.apphatchery.training.domain.repository

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun upsert(message: Any)
    suspend fun delete(message: Any)
    fun query(): Flow<List<*>>

}