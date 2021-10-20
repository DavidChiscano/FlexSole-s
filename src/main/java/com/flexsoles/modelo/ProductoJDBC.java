package com.flexsoles.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flexsoles.persistencia.Productos;

@Repository
public class ProductoJDBC implements Producto {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String setTitulo(Productos p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setDescripcion(Productos p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setId(Productos p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double setPrecio(Productos p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDescuento(Productos p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Productos> getProductos() {
		return jdbcTemplate.query("select * from Productos",
				(rs, rowNum) -> new Productos(rs.getString("titulo"), rs.getString("descripcion"), rs.getInt("id"), rs.getDouble("precio"), rs.getInt("descuento")));
	}

	@Override
	public int crearProducto(Productos p) {
		return jdbcTemplate.update("INSERT INTO Productos(titulo, descripcion, id, precio, descuento) values(?,?,?,?,?)",
				p.getTitulo(), p.getDescripcion(), p.getId(), p.getPrecio(), p.getDescuento());
	}

}
