package com.flexsoles.modelo;
import com.flexsoles.persistencia.Productos;

public interface Producto {
	String setTitulo(Producto p);
	String setDescripcion(Producto p);
	int setId(Producto p);
	double setPrecio(Producto p);
	int setDescuento(Producto p);
}
