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
	@RequestMapping(value = "/producto/crear", method = RequestMethod.GET)
	public String getCrear() {
		return "/producto/crear";
	}
//	@RequestMapping(value = "/producto/buscar", method = RequestMethod.GET)
//	public String getBuscarProducto() {
//		return "buscarProducto";
//	}
//	@RequestMapping(value = "/producto/borrar/idProducto", method = RequestMethod.GET)
//	public String getBorrarIdProducto() {
//		return "borrarIdProducto";
//	}
	
	
	//POST METHODS

	@RequestMapping(value = "/producto/crear", method = RequestMethod.POST)
	public String CrearProducto(@RequestParam String titulo,String descripcion, int id, double precio, int descuento,HttpServletRequest request, Model modelo) {
		request.getSession().setAttribute("titulo", titulo);
		request.getSession().setAttribute("descripcion", descripcion);
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("precio", precio);
		request.getSession().setAttribute("descuento", descuento);
		
		modelo.addAttribute("titulo_form",titulo);
		modelo.addAttribute("descripcion_form", descripcion);
		modelo.addAttribute("id_form", id);
		modelo.addAttribute("precio_form", precio);
		modelo.addAttribute("descuento_form", descuento);
		
		return "/producto/datosCrear";
	}
}
