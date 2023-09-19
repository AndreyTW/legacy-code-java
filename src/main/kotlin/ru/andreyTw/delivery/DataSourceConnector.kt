package ru.andreyTw.delivery

interface DataSourceConnector {

    fun openConnection()

    fun prepareResultSet(clientType: String)

    fun getDataByIndex(index: Int): Int

    fun closeConnection()
}
