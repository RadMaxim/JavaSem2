package org.example.MiddleJava2Sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionWithDataBase {
    private static final String url = "jdbc:postgresql://localhost:5432/middlejava";
    private static final String user = "postgres";
    private static final String password ="1111";

    public static Connection getConnection() throws Exception{
        Connection connection;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
