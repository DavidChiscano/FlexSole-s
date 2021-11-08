package com.flexsoles.persistencia;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Usuarios")
public class Usuario implements Serializable {
		
		// ATRIBUTOS
		@Column(name = "id")
		private long id;
	
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
		private String fechaNacimiento;


		//CONSTRUCTORES
		public Usuario(){}
	
		public Usuario(long id, String nombre, String apellidos, String email, String passwd, String fechaNacimiento ) {
			this.id = id;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.email = email;
			this.passwd = passwd;
			this.fechaNacimiento = fechaNacimiento;
		}
		public Usuario(long id, String nombre, String apellidos, String email, String fechaNacimiento ) {
			this.id = id;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.email = email;
			this.fechaNacimiento = fechaNacimiento;
		}
		public Usuario(String nombre, String passwd) {
			this.nombre = nombre;
			this.passwd = passwd;
		}
		//GETTERS & SETTERS
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
		
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


		public String getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(String fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		@Override 
		public String toString(){
			return this.nombre + " " + this.apellidos;	
		}
}


