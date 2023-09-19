package ru.andreyTw.delivery

import io.cucumber.java.ru.Дано
import io.cucumber.java.ru.И
import io.cucumber.java.ru.Когда
import io.cucumber.java.ru.Тогда
import org.junit.jupiter.api.Assertions
import org.springframework.web.client.RestTemplate

class DeliveryStepDefinitions {

    private var clientType: String? = null
    private var deliveryAmount: Int? = null
    private var cartAmount: Int? = null
    private var orderAmount: Int? = 0
    private val restTemplate = RestTemplate()

    @Дано("{string} и {int}")
    fun given(clientType: String, cartAmount: Int?) {
        this.clientType = clientType
        this.cartAmount = cartAmount
    }

    @И("Стоимость доствки {int}")
    fun and(deliveryAmount: Int?) {
        this.deliveryAmount = deliveryAmount
    }

    @Когда("Проводим расчет")
    fun `when`() {
        orderAmount =
            restTemplate.getForObject("http://localhost:8080/delivery/$clientType/$cartAmount/", Int::class.java)
    }

    @Тогда("Получаем {int}")
    fun then(orderAmount: Int?) {
        Assertions.assertEquals(orderAmount, this.orderAmount)
    }
}
