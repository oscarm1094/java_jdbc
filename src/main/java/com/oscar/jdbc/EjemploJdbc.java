package com.oscar.jdbc;


import com.oscar.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploJdbc {
    public static void main(String[] args) {


        // try con recursos permite que las clases con autocerrado ya no nos preocupemos por cerrarlo
        try (Connection connection = ConexionBaseDatos.getInstance();
             Statement statement = connection.createStatement();
             ResultSet resultado = statement.executeQuery("SELECT * FROM productos")) {

            while (resultado.next()) {
                System.out.print(resultado.getInt(1));
                System.out.print("|");
                System.out.print(resultado.getString("nombre"));
                System.out.print("|");
                System.out.print(resultado.getInt("precio"));
                System.out.print("|");
                System.out.println(resultado.getDate("fecha_registro"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
