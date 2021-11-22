package com.flexsoles.modelo;

import java.util.List;
import java.util.Optional;

import com.flexsoles.persistencia.Usuario;

public interface UsuarioDAO {
	String setNombre(Usuario u);
	String setApellido(Usuario u);
	String setEmail(Usuario u);
	String setPasswd(Usuario u);
	String setFecha(Usuario u);
	int crearUsuario(Usuario u);

	Usuario iniciarSesion(String nombre, String passwd);
	Optional<Usuario> buscarId(long id);
	List <Usuario> getUsuarios();
}
