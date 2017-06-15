package ar.unlam.programacion.avanzada.model;

import ar.unlam.programacion.avanzada.billeteraImpl.TipoMovimiento;

public class Pago extends TipoMovimiento {
	
private int registoPago;
    
	public Pago() {
		numeroOperacion++;
		System.out.println("numero Operacion de PAGO : " + numeroOperacion);
	}

	public String registrarPago() {
		this.registoPago += registoPago;
		return "se ha realizado un pago";
	}
	
	public int obtenerCantidadDePagos() {
		return registoPago;
	}

	@Override
	public String toString() {
		return "Pago";
	}
	
}
