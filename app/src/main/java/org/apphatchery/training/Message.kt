package org.apphatchery.training

import androidx.annotation.DrawableRes


data class Message(
    val username: String,
    val message: String,
    @DrawableRes
    val avatar: Int = R.drawable.user,
    val isMuted: Boolean = false,
    val isRead: Status = Status.LOADING,
    val timestamp: Long = System.currentTimeMillis()
)


