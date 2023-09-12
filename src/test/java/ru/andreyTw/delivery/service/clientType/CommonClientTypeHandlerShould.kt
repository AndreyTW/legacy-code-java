package ru.andreyTw.delivery.service.clientType

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.andreyTw.delivery.ClientType

class CommonClientTypeHandlerShould {

    private var commonClientTypeHandler: CommonClientTypeHandler? = null

    @BeforeEach
    fun setUp() {
        commonClientTypeHandler = CommonClientTypeHandler()
    }

    @Test
    fun return_1249_when_Obichny_and_999_are_given() {
        assertEquals(1249, commonClientTypeHandler!!.calculate(999))
    }

    @Test
    fun return_1000_when_Obichny_and_1000_are_given() {
        assertEquals(1000, commonClientTypeHandler!!.calculate(1000))
    }

    @Test
    fun returnCommonClientTypeWhenAsked() {
        assertEquals(ClientType.COMMON, commonClientTypeHandler?.getType())
    }
}
