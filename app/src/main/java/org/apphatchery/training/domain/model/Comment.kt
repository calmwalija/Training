package org.apphatchery.training.domain.model


data class Comment(
    val body: String,
    val email: String,
    val name: String,
    val postId: Int,
    val id: Int,
)