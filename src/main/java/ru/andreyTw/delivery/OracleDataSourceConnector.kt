package ru.andreyTw.delivery

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class OracleDataSourceConnector : DataSourceConnector {

    private var sqlQuery = "SELECT c.discount_amount, c.discount_percent FROM config_table c, client_type t " +
            "where t.id = c.type and t.type_name = ?"
    private lateinit var connection: Connection
    private var preparedStatement: PreparedStatement? = null
    private var resultSet: ResultSet? = null

    override fun openConnection() {
        try {
            val dataSource = OracleDataSource.create("admin", "p1ssword", "ORCL_PROD_DB1")
            connection = dataSource.connection
            preparedStatement = connection.prepareStatement(sqlQuery)
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    override fun prepareResultSet(clientType: String) {
        try {
            preparedStatement!!.setString(1, clientType)
            resultSet = preparedStatement!!.executeQuery()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    override fun getDataByIndex(index: Int): Int {
        try {
            if (resultSet!!.next()) {
                return resultSet!!.getInt(index)
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return 0
    }

    override fun closeConnection() {
        try {
            if (resultSet != null) resultSet!!.close()
            if (preparedStatement != null) preparedStatement!!.close()
            if (connection != null) connection!!.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
}
