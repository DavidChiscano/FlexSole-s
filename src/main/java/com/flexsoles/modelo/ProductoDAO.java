package com.flexsoles.modelo;
import java.util.List;
import java.util.Optional;
import com.flexsoles.persistencia.Productos;

public interface ProductoDAO {

	int crearProducto(Productos p);
	
	long borrarId(long id);
	
	List<Productos> get8Productos();
	
	Optional<Productos> buscarId(long id);
	
	List<Productos> buscarNombre(String titulo);
	
}


