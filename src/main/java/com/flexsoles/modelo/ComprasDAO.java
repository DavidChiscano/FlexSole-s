package com.flexsoles.modelo;

import java.util.List;
import java.util.Optional;

import com.flexsoles.persistencia.Compras;
import com.flexsoles.persistencia.Productos;
import com.flexsoles.persistencia.Usuario;

public interface ComprasDAO {
	
	List<Compras> getCompras(Long idUsuario);
	
	Compras crearCompra(Usuario u, Productos p);
	int insertarCompra(Compras c);
}
