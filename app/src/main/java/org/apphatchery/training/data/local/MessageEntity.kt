package org.apphatchery.training.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.apphatchery.training.R
import org.apphatchery.training.Status


@Entity
data class MessageEntity(
    val username: String,
    val message: String,
    val avatar: Int = R.drawable.hdwallpaper2468874_1920,
    val isMuted: Boolean = false,
    val isRead: String = Status.LOADING.name,
    val timestamp: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)