package org.apphatchery.training.data.remote

import org.apphatchery.training.data.local.comment.CommentEntity
import retrofit2.http.GET

interface RemoteSource {

    @GET("comments")
    suspend fun getComments(): List<CommentEntity>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/posts/1/"
    }

    
}