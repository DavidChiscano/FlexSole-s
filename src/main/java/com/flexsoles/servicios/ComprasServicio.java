package com.flexsoles.servicios;

import java.util.List;

import com.flexsoles.dtos.LineaCarrito;
import com.flexsoles.persistencia.Compras;
import com.flexsoles.persistencia.Usuario;

public interface ComprasServicio {

	Compras realizarCompra (Usuario u, List<LineaCarrito> listaCarrito);
	List<Compras> getCompras();

}
