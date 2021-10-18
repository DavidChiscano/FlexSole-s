package com.flexsoles.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlexSolesController {
	
	//VARIABLES PARA EL FORMULARIO CREAR PRODUCTO
	
	int id, descuento;
	String titulo, descripcion;
	double precio;
	
	//GET METHODS	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
//	@RequestMapping(value = "/producto/idProducto", method = RequestMethod.GET)
//	public String getIdProducto() {
//		return "idProducto";
//	}
//	@RequestMapping(value = "/producto/crear", method = RequestMethod.GET)
//	public String getCrearProducto() {
//		return "crearProducto";
//	}
//	@RequestMapping(value = "/producto/buscar", method = RequestMethod.GET)
//	public String getBuscarProducto() {
//		return "buscarProducto";
//	}
//	@RequestMapping(value = "/producto/borrar/idProducto", method = RequestMethod.GET)
//	public String getBorrarIdProducto() {
//		return "borrarIdProducto";
//	}
	
	//MAPPING
//	@GetMapping("/producto/crear")
//	public String process(Model model, HttpSession session, HttpServletRequest request) {
//	    id = (int)session.getAttribute("id");
//	    titulo = (String)session.getAttribute("titulo");
//	    descripcion = (String)session.getAttribute("descripcion");
//	    precio = (Double)session.getAttribute("precio");
//	    descuento = (int)session.getAttribute("descuento");
//	   
//	    return "crearProducto";
//	}
	
	
	//POST METHODS

//	@RequestMapping(value = "/producto/crear", method = RequestMethod.POST)
//	public String CrearProducto(@RequestParam int id, String titulo,String descripcion, double precio, int descuento,HttpServletRequest request) {
//		request.getSession().setAttribute("id", id);
//		request.getSession().setAttribute("titulo", titulo);
//		request.getSession().setAttribute("descripcion", descripcion);
//		request.getSession().setAttribute("precio", precio);
//		request.getSession().setAttribute("descuento", descuento);
//		
//		return "redirect:/index";
//	}
}
