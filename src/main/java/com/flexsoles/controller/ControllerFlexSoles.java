package com.flexsoles.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
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
import com.flexsoles.modelo.ProductoDAO;
import com.flexsoles.modelo.UsuarioDAO;
import com.flexsoles.persistencia.Compras;
import com.flexsoles.persistencia.Productos;
import com.flexsoles.persistencia.Usuario;
import com.flexsoles.servicios.ComprasServicio;

@Controller
public class ControllerFlexSoles {

	@Autowired
	private ProductoDAO productoModelo;
	@Autowired
	private UsuarioDAO usuarioModelo;
	@Autowired
	private ComprasDAO comprasModelo;
	
	@Autowired
	private ComprasServicio comprasServicio;
	

	// GET METHODS
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex2(Model modelo) {
		List<Productos> ListaProductos = productoModelo.get8Productos();
		modelo.addAttribute("ListaProductos", ListaProductos);
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex(Model modelo) {
		List<Productos> ListaProductos = productoModelo.get8Productos();
		modelo.addAttribute("ListaProductos", ListaProductos);
		return "index";
	}

	@RequestMapping(value = "/producto/producto{id}", method = RequestMethod.GET)
	public String getIdProducto(Model modelo, @PathVariable("id") long id) {
		Optional<Productos> ListaProductos = productoModelo.buscarId(id);
		Productos p1 = ListaProductos.get();
		modelo.addAttribute("ListaProductos", p1);
		return "/producto/producto";
	}

	@RequestMapping(value = "/producto/borrar/{id}", method = RequestMethod.GET)
	public String getBorrarIdProducto(@PathVariable("id") long id) {
		productoModelo.borrarId(id);
		return "redirect:/index";
	}

	@RequestMapping(value = "/producto/crear", method = RequestMethod.GET)
	public String getCrear() {
		return "/producto/crear";
	}

	@RequestMapping(value = "/producto/buscar", method = RequestMethod.GET)
	public String getBuscarProducto(Model modelo, @RequestParam String busqueda) {
		List<Productos> ListaProductos = productoModelo.buscarNombre(busqueda);
		modelo.addAttribute("ListaProductos", (ListaProductos));
		return "/producto/producto";
	}

	@RequestMapping(value = "/usuario/login", method = RequestMethod.GET)
	public String getLogin() {
		return "/usuario/login";
	}

	@RequestMapping(value = "/usuario/signup", method = RequestMethod.GET)
	public String getRegistro() {
		return "/usuario/signup";
	}

	@RequestMapping(value = "/usuario/logout", method = RequestMethod.GET)
	public String getLogOut(HttpSession session) {
		session.removeAttribute("usuario");
		session.invalidate();
		return "redirect:/index";
	}

	@RequestMapping(value = "/usuario/user{id}", method = RequestMethod.GET)
	public String getPerfil(Model modelo, @PathVariable("id") long id) {
		Optional<Usuario> ListaUsuarios = usuarioModelo.buscarId(id);
		Usuario u = ListaUsuarios.get();
		modelo.addAttribute("ListaUsuarios", u);
		return "/usuario/user";
	}

	@RequestMapping(value = "/compra/cesta", method = RequestMethod.GET)
	public String getCesta(Model modelo, HttpSession session) {
		List<Compras> carrito = (List<Compras>) session.getAttribute("carrito");
		modelo.addAttribute("ListaCompras", carrito);
		return "/compra/cesta";
	}

	@RequestMapping(value = "/compra/miscompras", method = RequestMethod.GET)
	public String getComprasRealizadas(Model modelo) {
		List<Compras> ListaComprasRealizadas = comprasServicio.getCompras();
		modelo.addAttribute("ListaComprasRealizadas", ListaComprasRealizadas);
		return "/compra/miscompras";
	}

	// POST METHODS
	@RequestMapping(value = "/producto/crear", method = RequestMethod.POST)
	public String CrearProducto(@RequestParam String titulo, String descripcion, double precio, int descuento,
			Model modelo) {
		Productos producto = new Productos();
		producto = new Productos(null, null, 0, 0, 0);
		producto.setTitulo(titulo);
		producto.setDescripcion(descripcion);
		producto.setPrecio(precio);
		producto.setDescuento(descuento);
		productoModelo.crearProducto(producto);
		return "redirect:/index";
	}

	@RequestMapping(value = "/usuario/signup", method = RequestMethod.POST)
	public String CrearUsuario(@RequestParam String nombre, String apellidos, String email, String passwd,
			String fechaNacimiento, HttpServletRequest request, Model modelo) {
		Usuario usuario = new Usuario();
		usuario = new Usuario(0, null, null, null, null, null);
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setEmail(email);
		usuario.setPasswd(passwd);
		usuario.setFechaNacimiento(fechaNacimiento);
		usuarioModelo.crearUsuario(usuario);
		return "redirect:/usuario/login";
	}

	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	public String iniciarSesion(Model modelo, @RequestParam String nombre, @RequestParam String passwd,
			HttpSession session) {
		Usuario usuario = usuarioModelo.iniciarSesion(nombre, passwd);
		session.setAttribute("usuario", usuario);
		return "redirect:/index";
	}

	// Carrito de la compra
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
	
	
	
	@RequestMapping(value = "/compra/realizarCompra", method = RequestMethod.GET)
	public String getRealizarCompra(HttpSession session, Model modelo) {
		Usuario user = (Usuario) session.getAttribute("usuario");
		List<LineaCarrito> carrito = (List<LineaCarrito>) session.getAttribute("carrito");
		Compras c = comprasServicio.realizarCompra(user, carrito);
		comprasModelo.insertarCompra(c);
		if (c==null)
			return "redirect:/index";
		
		modelo.addAttribute("Compras",c);
		return "/compra/miscompras";
	}
	
	@RequestMapping(value = "/compra/realizarCompra", method = RequestMethod.POST)
	public String getFinalizarCompra(HttpSession session, Model modelo) {
		Usuario user = (Usuario) session.getAttribute("usuario");
		List<LineaCarrito> carrito = (List<LineaCarrito>) session.getAttribute("carrito");
		Compras c = comprasServicio.realizarCompra(user, carrito);

		if (c==null)
			return "redirect:/index";
		
		modelo.addAttribute("Compras",c);
		comprasModelo.insertarCompra(c);
		return "/compra/miscompras";
	}
}
