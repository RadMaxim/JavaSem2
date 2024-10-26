package org.example.MiddleJava2Sem;

import java.sql.PreparedStatement;

public class WriteData {
    public static void WriteD(String name, int age) {
        String sqlInsert = "INSERT INTO javales1(name, age) VALUES (?,?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionWithDataBase.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setString(1, name); // Заменяем первый знак вопроса
            preparedStatement.setInt(2, age);  // Заменяем второй знак вопроса
            preparedStatement.executeUpdate();
            System.out.println("update");

        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println(e);
        }

    }
}
