package ru.andreyTw.delivery.service.clientType

import ru.andreyTw.delivery.ClientType

interface ClientTypeHandler {

    val type: ClientType

    fun calculate(cartAmount: Int): Int
}
