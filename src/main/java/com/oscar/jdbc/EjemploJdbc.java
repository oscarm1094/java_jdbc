package com.oscar.jdbc;


import com.oscar.jdbc.modelo.Producto;
import com.oscar.jdbc.repository.ProductoRepositoryImpl;
import com.oscar.jdbc.repository.Repositorio;
import com.oscar.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbc {
    public static void main(String[] args) {

        // En el video indica que establecemos una conexion aqui para tener una sola en la app
        // caso contrario hay que cerrar la conexion por cada metodo del repositorio.
        try (Connection connection = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositoryImpl();
            repositorio.findAll().forEach(p -> System.out.println(p.getNombre()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
