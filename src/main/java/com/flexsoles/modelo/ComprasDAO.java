package com.flexsoles.modelo;

import java.util.List;

import com.flexsoles.persistencia.Compras;

public interface ComprasDAO {
	public long setId(Compras c);
	public String setNombre(Compras c);
	public int setCantidad(Compras c);
	
	public List<Compras> getCesta();
	int crearCompra(Compras c);
}
