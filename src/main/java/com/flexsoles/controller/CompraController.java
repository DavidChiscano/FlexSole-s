package com.flexsoles.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flexsoles.dtos.LineaCarrito;
import com.flexsoles.modelo.ComprasDAO;
import com.flexsoles.persistencia.Compras;
import com.flexsoles.persistencia.Usuario;
import com.flexsoles.servicios.ComprasServicio;

@Controller
public class CompraController {

	@Autowired
	private ComprasDAO comprasModelo;
	@Autowired
	private ComprasServicio comprasServicio;
	
	
	// GET METHODS
	@RequestMapping(value = "/compra/cesta", method = RequestMethod.GET)
	public String getCesta(Model modelo, HttpSession session) {
		List<Compras> carrito = (List<Compras>) session.getAttribute("carrito");
		modelo.addAttribute("ListaCompras", carrito);
		return "/compra/cesta";
	}
	@RequestMapping(value = "/compra/miscompras{id}", method = RequestMethod.GET)
	public String getComprasRealizadas(Model modelo, @PathVariable("id") long id) {
		List<Compras> listaComprasRealizadas = comprasModelo.getCompras(id);
		modelo.addAttribute("listaComprasRealizadas", (listaComprasRealizadas));
		return "/compra/miscompras";
	}
	@RequestMapping(value = "/compra/devolverCompra{id}", method = RequestMethod.GET)
	public String devolverCompra(@PathVariable("id") long id, Model modelo){
		comprasModelo.devolverCompra(id);
		return "redirect:/index";
	}

	// POST METHODS
	@RequestMapping(value = "/compra/cesta", method = RequestMethod.POST)
	public String getCesta(Model modelo, HttpSession session, @RequestParam long id, @RequestParam String nombre,
			@RequestParam int cantidad) {
		LineaCarrito lineaC = new LineaCarrito();
		lineaC.setIdProducto(id);
		lineaC.setNombreProducto(nombre);
		lineaC.setCantidad(cantidad);

		List<LineaCarrito> carrito = (List<LineaCarrito>) session.getAttribute("carrito");

		// Carrito vacio
		if (carrito == null) {
			carrito = new ArrayList<LineaCarrito>();
			carrito.add(lineaC);

		} else {
			// en casos de que haya carrito
			Boolean added = false;

			for (LineaCarrito linea : carrito) {
				if (linea.getIdProducto() == lineaC.getIdProducto()) {
					// en caso de que el producto ya este en el carrito
					added = true;
					linea.setCantidad(linea.getCantidad() + cantidad);
				}
			}
			// en caso de que el producto no este en el carrito
			if (added == false) {
				carrito.add(lineaC);
			}
		}
		// guardar cambios en la session
		session.setAttribute("id", id);
		session.setAttribute("nombre", nombre);
		session.setAttribute("cantidad", cantidad);
		session.setAttribute("carrito", carrito);

		return "redirect:/compra/cesta";
	}
	
	@RequestMapping(value = "/compra/realizarCompra", method = RequestMethod.POST)
	public String FinalizarCompra(HttpSession session, Model modelo) {
		Usuario user = (Usuario) session.getAttribute("usuario");
		List<LineaCarrito> carrito = (List<LineaCarrito>) session.getAttribute("carrito");
		Compras c = comprasServicio.realizarCompra(user, carrito);

		for (int i = 0; i < carrito.size(); i++) {
			c.setIdUsuario(user.getId());
			c.setIdProducto(carrito.get(i).getIdProducto());
			c.setCantidad(carrito.get(i).getCantidad());
		}

		comprasModelo.insertarCompra(c);

		if (c == null) {
			return "redirect:/index";
		}

		return "redirect:/index";
	}
	
}
