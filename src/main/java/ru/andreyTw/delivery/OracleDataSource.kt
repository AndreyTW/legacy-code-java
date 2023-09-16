package ru.andreyTw.delivery

import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import javax.sql.DataSource

object OracleDataSource {

    @Throws(SQLException::class)
    fun create(user: String?, password: String?, instance: String?): DataSource {
        val ds = Mockito.mock(DataSource::class.java)
        val connection = Mockito.mock(Connection::class.java)
        val preparedStatement = Mockito.mock(PreparedStatement::class.java)
        val resultSet = Mockito.mock(ResultSet::class.java)
        Mockito.`when`(ds.connection).thenReturn(connection)
        Mockito.`when`(connection.prepareStatement(ArgumentMatchers.anyString())).thenReturn(preparedStatement)
        Mockito.`when`(preparedStatement.executeQuery()).thenReturn(resultSet)
        Mockito.`when`(resultSet.next()).thenReturn(true)
        Mockito.`when`(resultSet.getInt(0)).thenReturn(2500)
        Mockito.`when`(resultSet.getInt(1)).thenReturn(5)
        Mockito.`when`(resultSet.getInt(2)).thenReturn(2)
        return ds
    }
}
