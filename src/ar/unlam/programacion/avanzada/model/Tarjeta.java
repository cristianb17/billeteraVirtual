package ar.unlam.programacion.avanzada.model;

public class Tarjeta extends MedioPago {
	private static int numeroPago = 1;
	
	public Tarjeta() {
		identificador++;
		//System.out.println("identificador de pago Tarjeta : " + identificador);
	}
	
	public int obtenerCantidadDePagoTarjeta() {
		return numeroPago;
	}

	@Override
	public String toString() {
		return "Tarjeta";
	}

	@Override
	int obtenerCantidadDePagos() {
		// TODO Auto-generated method stub
		return identificador;
	}
	
	
	
}
