package org.example.MiddleJava2Sem;

import java.sql.ResultSet;
import java.sql.Statement;

public class ReadData {
    private static final String sql = "SELECT * FROM javales1";
    public static void getDataFromDataBase() throws Exception{
        Statement statement  = ConnectionWithDataBase.getConnection().createStatement();
        ResultSet resultSet =statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.print(resultSet.getString(1)+" ");
            System.out.print(resultSet.getString(2)+" ");
            System.out.print(resultSet.getString(3)+" ");

        }
    }
}
