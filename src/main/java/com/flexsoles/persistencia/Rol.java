package com.flexsoles.persistencia;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
public class Rol{
	private long id;
	private String nombre_rol;
	
	private Set<Usuario> usuarios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		usuario.getRoles().add(this);
	}
	
	public void borrarUsuario(Usuario usuario) {
		this.usuarios.remove(usuario) ;
	}
	public Rol(long id, String nombre_rol, Set<Usuario> usuarios) {
		super();
		this.id = id;
		this.nombre_rol = nombre_rol;
		this.usuarios = usuarios;
	}

	public Rol() {
		// TODO Auto-generated constructor stub
	}

	
	
}
