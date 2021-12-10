package com.flexsoles.persistencia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Productos implements Serializable {
	
	// ATRIBUTOS
	private String titulo;
	
	private String descripcion;
	
	private long id;
	
	private double precio;
	
	private int descuento;

	
	//CONSTRUCTORES
	public Productos(String titulo, String descripcion, long id, double precio, int descuento) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.id = id;
		this.precio = precio;
		this.descuento = descuento;
	}
	
	public Productos() {}

	public Productos(long id, String titulo, double precio) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
	}
	public Productos(long id, String titulo, double precio, int descuento, String descripcion) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.descuento = descuento;
		this.descripcion = descripcion;
	}
	
	public Productos(long id, String titulo, double precio, String descripcion) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.descripcion = descripcion;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return titulo + descripcion + id + precio + descuento;
	} 

}
