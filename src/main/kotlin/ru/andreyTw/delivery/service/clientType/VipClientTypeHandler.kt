package ru.andreyTw.delivery.service.clientType

import org.springframework.stereotype.Service
import ru.andreyTw.delivery.ClientType
import ru.andreyTw.delivery.DataSourceConnector
import ru.andreyTw.delivery.OracleDataSourceConnector

@Service
class VipClientTypeHandler : ClientTypeHandler {

    override fun calculate(cartAmount: Int): Int {
        val dataSourceConnector: DataSourceConnector = OracleDataSourceConnector()
        dataSourceConnector.openConnection()
        dataSourceConnector.prepareResultSet("VIP")
        val b = dataSourceConnector.getDataByIndex(0)
        val p = dataSourceConnector.getDataByIndex(1)
        dataSourceConnector.closeConnection()
        return when {
            cartAmount >= b -> (cartAmount * (1 - p / 100.0)).toInt()
            else -> cartAmount
        }
    }

    override val type: ClientType = ClientType.VIP
}
