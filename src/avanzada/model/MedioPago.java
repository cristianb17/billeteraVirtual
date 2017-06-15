package ar.unlam.programacion.avanzada.model;

public abstract class MedioPago {
	
	protected static int identificador = 0;
	private String nombre;
		
	protected MedioPago() {
	}

	public int getIdentificador() {
		return identificador;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	abstract int obtenerCantidadDePagos();
	
}
