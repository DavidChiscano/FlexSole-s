package com.flexsoles.modelo;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.flexsoles.dtos.LineaCarrito;
import com.flexsoles.persistencia.Compras;
import com.flexsoles.persistencia.Productos;
import com.flexsoles.persistencia.Usuario;
import com.flexsoles.servicios.ComprasServicio;

@Repository
public class ComprasJDBC implements ComprasDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	
	@Override
	public List<Compras> getCompras(Long idUsuario) {
		return jdbcTemplate.query("select * from Compras WHERE idUsuario=?",
				(rs, rowNum) -> new Compras(rs.getLong("id"), rs.getLong("idUsuario"),rs.getLong("idProducto"), rs.getInt("unidades")),idUsuario);
	}


	@Override
	public int insertarCompra(Compras c) {
		return jdbcTemplate.update("INSERT INTO Compras(idUsuario, idProducto, unidades) values(?,?,?)",
				c.getIdUsuario(), c.getIdProducto(), c.getCantidad());
	}



	@Override
	public Compras crearCompra(Usuario u, Productos p) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
