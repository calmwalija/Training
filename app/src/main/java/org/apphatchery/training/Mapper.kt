package org.apphatchery.training

import org.apphatchery.training.data.local.MessageEntity
import org.apphatchery.training.domain.model.Message

fun MessageEntity.toMessage() = Message(
    username = username,
    message = message
)