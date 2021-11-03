package com.flexsoles.persistencia;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Usuarios")
public class Usuario {
		
		// ATRIBUTOS
		@Column(name = "nombre")
		private String nombre;
		
		@Column(name = "apellidos")
		private String apellidos;
		
		@Id
		@Column(name = "email")
		private String email;
		
		@Column(name = "passwd")
		private String passwd;
		
		@Column(name = "fechaNacimiento")
		private String fecha;

		//CONSTRUCTORES
		public Usuario(){}
		
		public Usuario(String nombre, String apellidos, String email, String passwd, String fecha ) {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.email = email;
			this.passwd = passwd;
			this.fecha = fecha;
		}
		
		public Usuario(String nombre, String passwd) {
			this.nombre = nombre;
			this.passwd = passwd;
		}
		//GETTERS & SETTERS
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPasswd() {
			return passwd;
		}

		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}


}


