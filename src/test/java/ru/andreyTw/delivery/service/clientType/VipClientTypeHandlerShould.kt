package ru.andreyTw.delivery.service.clientType

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.andreyTw.delivery.ClientType

class VipClientTypeHandlerShould {

    private lateinit var vipClientTypeHandler: VipClientTypeHandler

    @BeforeEach
    fun setUp() {
        vipClientTypeHandler = VipClientTypeHandler()
    }

    @Test
    fun return_999_when_VIP_and_999_are_given() {
        assertEquals(999, vipClientTypeHandler.calculate(999))
    }

    @Test
    fun return_2499_when_VIP_and_2499_are_given() {
        assertEquals(2499, vipClientTypeHandler.calculate(2499))
    }

    @Test
    fun return_2500_when_VIP_and_2375_are_given() {
        assertEquals(2375, vipClientTypeHandler.calculate(2500))
    }

    @Test
    fun returnCommonClientTypeWhenAsked() {
        assertEquals(ClientType.VIP, vipClientTypeHandler.type)
    }
}
