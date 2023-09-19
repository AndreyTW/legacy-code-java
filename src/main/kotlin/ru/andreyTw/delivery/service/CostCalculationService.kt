package ru.andreyTw.delivery.service

import ru.andreyTw.delivery.service.clientType.UnknownClientTypeException

interface CostCalculationService {

    @Throws(UnknownClientTypeException::class)
    fun calculate(clientType: String, cartAmount: Int): Int
}
