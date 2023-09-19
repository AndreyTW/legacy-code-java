package ru.andreyTw.delivery

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import ru.andreyTw.delivery.service.clientType.UnknownClientTypeException

class ClientTypeShould {
    @Test
    @Throws(UnknownClientTypeException::class)
    fun parseCorrectType() {
        assertNotNull(ClientType.titleOf("Обычный"))
    }

    @Test
    fun parseIncorrectType() {
        assertThrows(UnknownClientTypeException::class.java) { ClientType.titleOf("Неизвестный") }
    }
}