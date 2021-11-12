package com.flexsoles.modelo;
import java.util.List;
import java.util.Optional;
import com.flexsoles.persistencia.Productos;

public interface ProductoDAO {
	String setTitulo(Productos p);
	String setDescripcion(Productos p);
	long setId(Productos p);
	double setPrecio(Productos p);
	int setDescuento(Productos p);
	int crearProducto(Productos p);
	long borrarId(long id);

	List<Productos> get8Productos();
	
	Optional<Productos> buscarId(long id);
	
	List<Productos> buscarNombre(String titulo);
	
}


