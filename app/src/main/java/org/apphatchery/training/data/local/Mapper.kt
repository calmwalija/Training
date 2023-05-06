package org.apphatchery.training.data.local
import org.apphatchery.training.domain.model.Message
import org.apphatchery.training.data.local.MessageEntity

fun MessageEntity.toMessage():Message{

    return Message(username, message)
}