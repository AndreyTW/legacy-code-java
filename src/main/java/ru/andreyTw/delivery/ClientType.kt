package ru.andreyTw.delivery

import ru.andreyTw.delivery.service.clientType.UnknownClientTypeException
import java.util.Arrays

enum class ClientType(
    val title: String
) {

    COMMON("Обычный"),
    VIP("VIP"),
    FnF("Friends&Family");

    companion object {

        @Throws(UnknownClientTypeException::class)
        fun titleOf(title: String?): ClientType = Arrays.stream(entries.toTypedArray())
            .filter { clientType: ClientType -> clientType.title == title }
            .findFirst()
            .orElseThrow { UnknownClientTypeException(title!!) }
    }
}
