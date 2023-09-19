package ru.andreyTw.delivery

import ru.andreyTw.delivery.service.clientType.UnknownClientTypeException

enum class ClientType(
    val title: String
) {

    COMMON("Обычный"),
    VIP("VIP"),
    FnF("Friends&Family");

    companion object {

        fun titleOf(title: String): ClientType = entries
            .firstOrNull { it.title == title }
            .takeIf { it != null } ?: throw UnknownClientTypeException(title)
    }
}
