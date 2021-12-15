package com.flexsoles.persistencia;

import java.io.Serializable;
import java.util.Objects;

public class Rol implements Serializable{
	private long id;
	private String nombre_rol;


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

	public Rol(long id, String nombre_rol) {
		super();
		this.id = id;
		this.nombre_rol = nombre_rol;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return id == other.id;
	}

	public Rol() {
		// TODO Auto-generated constructor stub
	}	
}
