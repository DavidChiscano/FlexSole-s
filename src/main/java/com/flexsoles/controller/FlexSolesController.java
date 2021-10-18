package com.flexsoles.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class FlexSolesController {
	//GET METHODS	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getQuiz() {
		return "index";
	}
	@RequestMapping(value = "/producto/idProducto", method = RequestMethod.GET)
	public String getIdProducto() {
		return "idProducto";
	}
	@RequestMapping(value = "/producto/crear", method = RequestMethod.GET)
	public String getCrearProducto() {
		return "crearProducto";
	}
	@RequestMapping(value = "/producto/buscar", method = RequestMethod.GET)
	public String getBuscarProducto() {
		return "buscarProducto";
	}
}
