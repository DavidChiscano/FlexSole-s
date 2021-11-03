package com.flexsoles.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flexsoles.persistencia.Productos;
import com.flexsoles.persistencia.Usuario;

@Repository
public class UsuarioJDBC implements UsuarioDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String setNombre(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setApellido(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setEmail(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setPasswd(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date setFecha(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getUsuarios() {
		return jdbcTemplate.query("select * from Usuarios",
				(rs, rowNum) -> new Usuario(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("email"), rs.getString("passwd"), rs.getDate("fechaNacimiento")));
	}

	@Override
	public int crearUsuario(Usuario u) {
		return jdbcTemplate.update("INSERT INTO Usuarios(nombre, apellidos, email, passwd, fechaNacimiento) values(?,?,?,?,?)",
				u.getNombre(), u.getApellidos(), u.getEmail(), u.getPasswd(), u.getFecha());
	}

}
