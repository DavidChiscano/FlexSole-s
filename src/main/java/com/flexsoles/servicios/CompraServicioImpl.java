package com.flexsoles.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexsoles.dtos.LineaCarrito;
import com.flexsoles.modelo.ComprasDAO;
import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.persistencia.Compras;
import com.flexsoles.persistencia.Productos;
import com.flexsoles.persistencia.Usuario;

@Service
@Transactional
public class CompraServicioImpl implements ComprasServicio{

	@Autowired
	private ComprasDAO comprasModelo;
	
	@Autowired
	private ProductoDAO productoModelo;
	
	@Override
	public Compras realizarCompra(Usuario u, List<LineaCarrito> listaCarrito) {
		int resultado = 0;
		Productos p = productoModelo.buscarId(listaCarrito.get(0).getIdProducto()).orElse(null);
		Compras compra = new Compras();
		
		if (p != null) {
			resultado = comprasModelo.insertarCompra(compra);
		}

		//SI ES 0 O NULO HA FALLADO
		if(resultado == 0){
			return null;
		}else {
			return compra;
		}

	}

	@Override
	public List<Compras> getCompras() {
		// TODO Auto-generated method stub
		return null;
	}

}
