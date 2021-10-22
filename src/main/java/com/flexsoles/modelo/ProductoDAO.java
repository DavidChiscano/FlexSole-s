package com.flexsoles.modelo;
import java.util.List;

import com.flexsoles.persistencia.Productos;

public interface ProductoDAO {
	String setTitulo(Productos p);
	String setDescripcion(Productos p);
	int setId(Productos p);
	double setPrecio(Productos p);
	int setDescuento(Productos p);
	
	int crearProducto(Productos p);
	int borrarProducto(Productos p);
	List<Productos> getProductos();

}


