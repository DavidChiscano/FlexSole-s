package com.flexsoles.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flexsoles.persistencia.Compras;
@Component 
public class ComprasJDBC implements ComprasDAO {
	@Autowired
	private ComprasDAO moduloCompras;
	
	@Override
	public long setId(Compras c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String setNombre(Compras c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setCantidad(Compras c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Compras> getCesta() {
		// TODO Auto-generated method stub
		return moduloCompras.getCesta();
	}

	@Override
	public int crearCompra(Compras c) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
