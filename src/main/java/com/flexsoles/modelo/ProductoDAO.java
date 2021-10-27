package com.flexsoles.modelo;
import java.util.List;
import java.util.Optional;

import com.flexsoles.persistencia.Productos;

public interface ProductoDAO {
	String setTitulo(Productos p);
	String setDescripcion(Productos p);
	int setId(Productos p);
	double setPrecio(Productos p);
	int setDescuento(Productos p);
	int crearProducto(Productos p);
	int borrarId(int id);

	List<Productos> getProductos();
	
	Optional<Productos> buscarId(int id);
	
	Optional<Productos> buscarNombre(String titulo);
}


