package com.flexsoles.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Productos")
public class Producto {
	
	// ATRIBUTOS
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "descuento")
	private int descuento;

	
	//CONSTRUCTOR
	public Producto(String titulo, String descripcion, int id, double precio, int descuento) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.id = id;
		this.precio = precio;
		this.descuento = descuento;
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
	

}
