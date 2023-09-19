package ru.andreyTw.delivery

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.andreyTw.delivery.service.CostCalculationService
import ru.andreyTw.delivery.service.clientType.UnknownClientTypeException

@RestController
class DeliveryController(
    private val costCalculationService: CostCalculationService
) {

    @GetMapping("/delivery/{clientType}/{cartAmount}/")
    @Throws(UnknownClientTypeException::class)
    fun calculate(
        @PathVariable("clientType") clientType: String,
        @PathVariable("cartAmount") cartAmount: Int
    ): Int = costCalculationService.calculate(clientType, cartAmount)
}
