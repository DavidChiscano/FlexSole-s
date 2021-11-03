package com.flexsoles.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.persistencia.Productos;

@Controller
public class ProductController {
	//CONSTRUCTORES
	private Productos producto;
	
	@Autowired
	private ProductoDAO productoModelo;
	
	//VARIABLES PARA EL FORMULARIO CREAR PRODUCTO
	
	int id;
	int descuento;
	String titulo;
	String descripcion;
	double precio;

	//GET METHODS	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex(Model modelo) {
		List<Productos> ListaProductos = productoModelo.getProductos();
		modelo.addAttribute("ListaProductos", ListaProductos);
		return "index";
	}
	@RequestMapping(value = "/producto/producto{id}", method = RequestMethod.GET)
	public String getIdProducto(Model modelo, @PathVariable("id") int id) {
		Optional<Productos> ListaProductos = productoModelo.buscarId(id);
		Productos p1 = ListaProductos.get();
		modelo.addAttribute("ListaProductos", p1);
		return "/producto/producto";
	}
	@RequestMapping(value = "/producto/crear", method = RequestMethod.GET)
	public String getCrear() {
		return "/producto/crear";
	}
	@RequestMapping(value = "/producto/buscar", method = RequestMethod.GET)
	public String getBuscarProducto(Model modelo,@RequestParam String busqueda) {

List<Productos> ListaProductos = productoModelo.buscarNombre(busqueda);
		modelo.addAttribute("ListaProductos", (ListaProductos));
		return "/producto/producto";
	}

	//POST METHODS
	@RequestMapping(value = "/producto/crear", method = RequestMethod.POST)
	public String CrearProducto(@RequestParam String titulo,String descripcion, double precio, int descuento,HttpServletRequest request, Model modelo) {
		producto = new Productos(null, null, 0, 0, 0);
		producto.setTitulo(titulo);
		producto.setDescripcion(descripcion);
		producto.setPrecio(precio);
		producto.setDescuento(descuento);
		productoModelo.crearProducto(producto);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/producto/borrar/{id}", method = RequestMethod.GET)
	public String getBorrarIdProducto(@PathVariable("id") int id){
		productoModelo.borrarId(id);
		return "redirect:/index";
	}
	
	//CONVERTIR OPTIONAL A LIST
	public static <T> List<T> toList(Optional<T> opt) {
	    return opt
	            .map(Collections::singletonList)
	            .orElseGet(Collections::emptyList);
	}
	
	
}
