package com.flexsoles.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flexsoles.modelo.UsuarioDAO;
import com.flexsoles.persistencia.Usuario;
@Transactional
@Service
public class UsuarioServicioImpl implements UsuarioServicio,UserDetailsService {

//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UsuarioDAO UsuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int crearUsuario(Usuario u) {
		//encriptar la contraseña
		//u.setPasswd(bCryptPasswordEncoder.encode(u.getPasswd()));
		//return UsuarioDAO.crearUsuario(u);
		return 0;
	}

	@Override
	public Usuario buscarPorNombreUsuario(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
