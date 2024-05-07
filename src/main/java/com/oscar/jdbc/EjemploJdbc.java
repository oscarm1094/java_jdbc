package com.oscar.jdbc;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/java_curso";
        String username="postgres";
        String password="postgres";

        try {
            Connection conection = DriverManager.getConnection(url,username,password);
            Statement statement = conection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT * FROM productos");

            while(resultado.next()){
                System.out.println(resultado.getString("nombre"));
            }


            resultado.close();
            statement.close();
            conection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
