package com.flexsoles.modelo;

import java.util.Date;
import java.util.List;

import com.flexsoles.persistencia.Usuario;

public interface UsuarioDAO {
	String setNombre(Usuario u);
	String setApellido(Usuario u);
	String setEmail(Usuario u);
	String setPasswd(Usuario u);
	Date setFecha(Usuario u);
	int crearUsuario(Usuario u);
	List <Usuario> getUsuarios();
}
