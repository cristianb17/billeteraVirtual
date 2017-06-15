package ar.unlam.programacion.avanzada.model;

import ar.unlam.programacion.avanzada.billeteraImpl.Billetera;

public class Usuario {
	private String nombre;
	private String apellido;
        private String password;
	private long dni;
	private String ciudad;
	private Billetera billetera;
	
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public Billetera getBilletera() {
		return billetera;
	}
	public void setBilletera(Billetera billetera) {
		this.billetera = billetera;
	}
	
	
	
}
