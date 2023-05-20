package org.apphatchery.training.data.remote

import org.w3c.dom.Comment
import retrofit2.http.GET

interface CommentsRemoteDataSource {

    @GET("comments")
    suspend fun getComments(): List<Comment>

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/posts/1/"
    }
}
