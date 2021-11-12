package com.flexsoles.modelo;

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
	public long setId(Productos p) {
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
	public List<Productos> get8Productos() {
		return jdbcTemplate.query("select * from Productos LIMIT 8",
				(rs, rowNum) -> new Productos(rs.getString("titulo"), rs.getString("descripcion"), rs.getLong("id"), rs.getDouble("precio"), rs.getInt("descuento")));
	}

	@Override
	public int crearProducto(Productos p) {
		return jdbcTemplate.update("INSERT INTO Productos(titulo, descripcion, precio, descuento) values(?,?,?,?)",
				p.getTitulo(), p.getDescripcion(), p.getPrecio(), p.getDescuento());
	}

	@Override
	public long borrarId(long id) {
		return jdbcTemplate.update("delete from Productos where id = ?", id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Productos> buscarId(long id) {
		return jdbcTemplate.queryForObject("select * from Productos where id = ?", new Object[] { id }, (rs,
				rowNum) -> Optional.of(new Productos(rs.getLong("id"), rs.getString("titulo"), rs.getDouble("precio"), rs.getInt("descuento"), rs.getString("descripcion"))));
	}
	@Override
	public List<Productos> buscarNombre(String titulo) {
		return jdbcTemplate.query("select * from Productos where titulo like ?", (rs,
				rowNum) -> new Productos(rs.getLong("id"), rs.getString("titulo"), rs.getDouble("precio"), rs.getInt("descuento"), rs.getString("descripcion")), "%"+titulo+"%" );
	}

	
}
