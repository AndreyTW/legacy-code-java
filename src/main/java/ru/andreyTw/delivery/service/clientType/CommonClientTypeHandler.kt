package ru.andreyTw.delivery.service.clientType

import org.springframework.stereotype.Service
import ru.andreyTw.delivery.ClientType

@Service
class CommonClientTypeHandler : ClientTypeHandler {

    override fun calculate(cartAmount: Int): Int = if (cartAmount >= 1000) cartAmount else cartAmount + 250

    override fun getType(): ClientType = ClientType.COMMON
}
