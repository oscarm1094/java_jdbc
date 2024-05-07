package com.oscar.jdbc.repository;

import com.oscar.jdbc.modelo.Producto;
import com.oscar.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryImpl implements Repositorio<Producto> {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> lista = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM productos")) {

            while (result.next()) {
                Producto producto = new Producto();
                producto.setId(result.getInt("id"));
                producto.setNombre(result.getString("nombre"));
                producto.setPrecio(result.getInt("precio"));
                // como la clase Date del sql hereda de la util. Date no hay problema en la conversion.
                producto.setFechaRegistro(result.getDate("fecha_registro"));

                lista.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public Producto findById(Integer id) {
        return null;
    }

    @Override
    public void save(Producto producto) {

    }

    @Override
    public void delete(Integer id) {

    }
}
