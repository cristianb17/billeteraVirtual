package ar.unlam.programacion.avanzada.model;

public class Efectivo extends MedioPago {
	private int registoPagoEfectivo;
	
	public Efectivo() {
		identificador++;
		//System.out.println("identificador de pago Efectivo : " + identificador);
	}
	
	public String realizarPagoConEfectivo() {
		this.registoPagoEfectivo += registoPagoEfectivo;
		return "se ha realizado un pago en Efectivo";
	}
	
	public int obtenerCantidadDePagoEfectivo() {
		return registoPagoEfectivo;
	}

	@Override
	public String toString() {
		return "Efectivo";
	}

	@Override
	int obtenerCantidadDePagos() {
		return identificador;
	}	
}
