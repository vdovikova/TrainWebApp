package vdovikova.trainapp.repos.database;

import lombok.RequiredArgsConstructor;
import java.sql.*;

@RequiredArgsConstructor
public class DatabaseManagerImpl implements DatabaseManager{

    private final String url;
    private final String username;
    private final String password;
    private Connection connection;

    private static DatabaseManagerImpl instance;

    public static DatabaseManagerImpl getInstance(){
        if (instance == null)
            instance = new DatabaseManagerImpl();
        return instance;
    }

    private DatabaseManagerImpl(){
        url = "jdbc:mysql://localhost:3306/tickettoride";
        username = "root";
        password = "1234";
    }

    @Override
    public void connect(){
        try {
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public ResultSet executeQuery(String str) {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = connection.prepareStatement(str);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int executeUpdate(String str) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(str);
            rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public void closeConnection() throws SQLException {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
