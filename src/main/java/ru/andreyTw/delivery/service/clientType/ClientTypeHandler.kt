package ru.andreyTw.delivery.service.clientType

import ru.andreyTw.delivery.ClientType

interface ClientTypeHandler {

    fun calculate(cartAmount: Int): Int

    fun getType(): ClientType
}
