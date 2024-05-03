package vdovikova.trainapp.repos.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseManager {
    void connect();
    Connection getConnection();
    void closeConnection() throws SQLException;
    ResultSet executeQuery(String str);
    int executeUpdate(String str);
}
