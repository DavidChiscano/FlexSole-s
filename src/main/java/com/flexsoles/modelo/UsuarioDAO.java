package com.flexsoles.modelo;

import java.util.List;
import java.util.Optional;

import com.flexsoles.persistencia.Usuario;

public interface UsuarioDAO {
	int crearUsuario(Usuario u);

	Usuario iniciarSesion(String nombre, String passwd);
	Optional<Usuario> buscarId(long id);
	List <Usuario> getUsuarios();
	Usuario getUsuarios(String nombre);

}
