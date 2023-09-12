package ru.andreyTw.delivery.service.clientType

class UnknownClientTypeException(clientType: String) : Throwable("Client type is not found: $clientType") 