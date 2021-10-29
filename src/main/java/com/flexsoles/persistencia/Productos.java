package com.flexsoles.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Productos")
public class Productos {
	
	// ATRIBUTOS
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "descuento")
	private int descuento;

	
	//CONSTRUCTORES
	public Productos(String titulo, String descripcion, int id, double precio, int descuento) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.id = id;
		this.precio = precio;
		this.descuento = descuento;
	}
	
	public Productos() {}

	public Productos(int id, String titulo, double precio) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
	}
	public Productos(int id, String titulo, double precio, String descripcion) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
