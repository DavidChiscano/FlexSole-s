package com.flexsoles.modelo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
	public String setFecha(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getUsuarios() {
		return jdbcTemplate.query("select * from Usuarios",
				(rs, rowNum) -> new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("email"), rs.getString("passwd"), rs.getString("fechaNacimiento")));
	}

	@Override
	public int crearUsuario(Usuario u) {
		return jdbcTemplate.update("INSERT INTO Usuarios(nombre, apellidos, email, passwd, fechaNacimiento) values(?,?,?,?,?)",
				u.getNombre(), u.getApellidos(), u.getEmail(), u.getPasswd(), u.getFecha());
	}

	@Override
	public Usuario iniciarSesion(String nombre, String passwd) {
		return  jdbcTemplate.queryForObject("select * from Usuarios where nombre like ? AND passwd like ?", (rs,
				rowNum) -> new Usuario(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"), rs.getString("passwd"), rs.getString("fechaNacimiento")), nombre, passwd);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Usuario> buscarId(int id) {
		return jdbcTemplate.queryForObject("select * from Usuarios where id = ?", new Object[] { id }, (rs,
				rowNum) -> Optional.of(new Usuario(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"), rs.getString("passwd"), rs.getString("fechaNacimiento"))));	
		}

}
