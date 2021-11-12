package com.flexsoles.modelo;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.flexsoles.persistencia.Compras;
@Component 
public class ComprasJDBC implements ComprasDAO {
	
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
        ArrayList<Compras> compra = new ArrayList<Compras>();
		Compras cesta = new Compras();
        cesta.setId(0);
		cesta.setNombre("2");
		cesta.setCantidad(0);
		compra.add(cesta);
		return compra;
	}

	@Override
	public int crearCompra(Compras c) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
