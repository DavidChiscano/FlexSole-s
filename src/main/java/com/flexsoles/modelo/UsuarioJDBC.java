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
	public List<Usuario> getUsuarios() {
		return jdbcTemplate.query("select * from UsuariosSecurity",
				(rs, rowNum) -> new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("rol"), rs.getString("email"), rs.getString("passwd"), rs.getString("fechaNacimiento")));
	}

	@Override
	public int crearUsuario(Usuario u) {
		return jdbcTemplate.update("INSERT INTO UsuariosSecurity(nombre, apellidos, rol, email, passwd, fechaNacimiento) values(?,?,?,?,?,?)",
				u.getNombre(), u.getApellidos(), u.getRoles(), u.getEmail(), u.getPasswd(), u.getFechaNacimiento());
	}

	@Override
	public Usuario iniciarSesion(String nombre, String passwd) {
		return  jdbcTemplate.queryForObject("select * from UsuariosSecurity where nombre like ? AND passwd like ?", (rs,
				rowNum) -> new Usuario(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellidos"), rs.getString("rol"), rs.getString("email"), rs.getString("passwd"), rs.getString("fechaNacimiento")), nombre, passwd);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Usuario> buscarId(long id) {
		return jdbcTemplate.queryForObject("select * from UsuariosSecurity where id = ?", new Object[] { id }, (rs,
				rowNum) -> Optional.of(new Usuario(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"), rs.getString("fechaNacimiento"))));	
		}

	@Override
	public Usuario getUsuarios(String nombre) {
		return  jdbcTemplate.queryForObject("select * from UsuariosSecurity where nombre like ?", (rs,
				rowNum) -> new Usuario(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellidos"), rs.getString("rol"),rs.getString("email"), rs.getString("passwd"), rs.getString("fechaNacimiento")), "%"+nombre+"%");
	}


}
