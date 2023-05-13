package org.apphatchery.training.domain.model

import androidx.annotation.DrawableRes
import org.apphatchery.training.R
import org.apphatchery.training.Status


data class Message(
    val username: String,
    val message: String,
    @DrawableRes
    val id:Int = 0,
    val avatar: Int = R.drawable.baseline_check_24,
    val isMuted: Boolean = false,
    val isRead: Status = Status.LOADING,
    val timestamp: Long = System.currentTimeMillis()
)


