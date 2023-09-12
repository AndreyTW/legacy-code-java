package ru.andreyTw.delivery.service.clientType

import org.springframework.stereotype.Service
import ru.andreyTw.delivery.ClientType
import ru.andreyTw.delivery.DataSourceConnector
import ru.andreyTw.delivery.OracleDataSourceConnector

@Service
class FnFClientTypeHandler : ClientTypeHandler {

    override fun calculate(cartAmount: Int): Int {
        val dataSourceConnector: DataSourceConnector = OracleDataSourceConnector()
        dataSourceConnector.openConnection()
        dataSourceConnector.prepareResultSet("Friends&Family")
        val p = dataSourceConnector.getDataByIndex(2)
        dataSourceConnector.closeConnection()
        return (cartAmount * (1 - p / 100.0)).toInt()
    }

    override val type: ClientType = ClientType.FnF
}
