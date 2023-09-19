package ru.andreyTw.delivery.service

import org.springframework.stereotype.Service
import ru.andreyTw.delivery.ClientType
import ru.andreyTw.delivery.service.clientType.ClientTypeHandler

@Service
class DeliveryCostCalculationService(
    handlerList: List<ClientTypeHandler?>
) : CostCalculationService {

    private val handlers: Map<ClientType?, ClientTypeHandler?>

    init {
        handlers = handlerList.associateBy({ it?.type }, { it })
    }

    fun getClientDeliveryService(clientType: ClientType): ClientTypeHandler? {
        return handlers[clientType]
    }

    override fun calculate(clientType: String, cartAmount: Int): Int {
        return getClientDeliveryService(ClientType.titleOf(clientType))!!.calculate(cartAmount)
    }
}
