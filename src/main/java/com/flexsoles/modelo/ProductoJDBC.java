package com.flexsoles.modelo;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flexsoles.persistencia.Productos;

@Repository
public class ProductoJDBC implements ProductoDAO {

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
		return jdbcTemplate.update("INSERT INTO Productos(titulo, descripcion, precio, descuento) values(?,?,?,?)",
				p.getTitulo(), p.getDescripcion(), p.getPrecio(), p.getDescuento());
	}

	@Override
	public int borrarId(int id) {
		return jdbcTemplate.update("delete from Productos where id = ?", id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Productos> buscarId(int id) {
		return jdbcTemplate.queryForObject("select * from Productos where id = ?", new Object[] { id }, (rs,
				rowNum) -> Optional.of(new Productos(rs.getInt("id"), rs.getString("titulo"), rs.getDouble("precio"))));
	}
	@Override
	public Optional<Productos> buscarNombre(String titulo) {
		return jdbcTemplate.queryForObject("select * from Productos where titulo = ?", (rs,
				rowNum) -> Optional.of(new Productos(rs.getInt("id"), rs.getString("titulo"), rs.getDouble("precio"))), new Object[] { titulo });
	}

	
}
