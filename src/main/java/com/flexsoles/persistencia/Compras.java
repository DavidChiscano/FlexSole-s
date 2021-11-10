package com.flexsoles.persistencia;

import java.io.Serializable;

public class Compras implements Serializable {
	// ATRIBUTOS
	private long id;
	private String nombre;
	private int cantidad;
	
	//CONSTRUCTORES
	
	public Compras(){}
	
	public Compras(long id, String nombre, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	//GETTERS & SETTERS
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
