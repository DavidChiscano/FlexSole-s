package com.flexsoles.persistencia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Compras implements Serializable {
	// ATRIBUTOS

	private long idCompra;

	private long idProducto;

	private long idUsuario;

	private int cantidad;
	// CONSTRUCTORES

	public Compras() {
	}

	public Compras(long idCompra, long idUsuario,long idProducto,  int cantidad) {
		super();
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		this.idUsuario = idUsuario;
		this.cantidad = cantidad;
	}

	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Compras [idCompra=" + idCompra + ", idProducto=" + idProducto + ", idUsuario=" + idUsuario
				+ ", cantidad=" + cantidad + "]";
	}

}
