package com.flexsoles.controller;

import java.util.List;

import java.util.Optional;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.modelo.UsuarioDAO;
import com.flexsoles.persistencia.Productos;
import com.flexsoles.persistencia.Usuario;

@Controller
public class ProductController {

	@Autowired
	private ProductoDAO productoModelo;
	@Autowired
	private UsuarioDAO usuarioModelo;


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
	
	@RequestMapping(value = "/usuario/login", method = RequestMethod.GET)
	public String getLogin(Model modelo) {
		return "/usuario/login";
	}
	@RequestMapping(value = "/usuario/signup", method = RequestMethod.GET)
	public String getRegistro(Model modelo) {
		return "/usuario/signup";
	}

	//POST METHODS
	@RequestMapping(value = "/producto/crear", method = RequestMethod.POST)
	public String CrearProducto(@RequestParam String titulo,String descripcion, double precio, int descuento,HttpServletRequest request, Model modelo) {
		Productos producto = new Productos();
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
	
	@RequestMapping(value = "/usuario/signup", method = RequestMethod.POST)
	public String CrearUsuario(@RequestParam String nombre,String apellidos, String email, String passwd, String fechaNacimiento, HttpServletRequest request, Model modelo) {
		
		Usuario usuario= new Usuario();
		usuario = new Usuario(null, null, null, null, null);
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setEmail(email);
		usuario.setPasswd(passwd);
		usuario.setFecha(fechaNacimiento);
		usuarioModelo.crearUsuario(usuario);

		return "redirect:/usuario/login";
	}
	
	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	public String iniciarSesion(Model modelo, @RequestParam String nombre, @RequestParam String passwd, HttpSession httpSession ) {
		Usuario usuario = usuarioModelo.iniciarSesion(nombre, passwd);
		httpSession.setAttribute("usuario", usuario.toString());
		return "redirect:/index";
	}
	
}
