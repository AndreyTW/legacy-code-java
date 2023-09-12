package ru.andreyTw.delivery.service.clientType

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.andreyTw.delivery.ClientType

class FnFClientTypeHandlerShould {

    private lateinit var fnFClientTypeHandler: FnFClientTypeHandler

    @BeforeEach
    fun setUp() {
        fnFClientTypeHandler = FnFClientTypeHandler()
    }

    @Test
    fun return_980_when_FriendsAndFamily_and_1000_are_given() {
        assertEquals(980, fnFClientTypeHandler.calculate(1000))
    }

    @Test
    fun returnCommonClientTypeWhenAsked() {
        assertEquals(ClientType.FnF, fnFClientTypeHandler.type)
    }
}
