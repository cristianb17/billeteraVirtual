package ar.unlam.programacion.avanzada.model;

import ar.unlam.programacion.avanzada.billeteraImpl.TipoMovimiento;

public class Compra extends TipoMovimiento {
	
private int registoCompra;

	public Compra() {
		numeroOperacion++;
		System.out.println("numero Operacion de COMPRA : " + numeroOperacion);
	}
	
	public String registrarCompra() {
		this.registoCompra += registoCompra;
		return "se ha realizado una Compra";
	}
	
	public int obtenerCantidadDeCompras() {
		return registoCompra;
	}

	@Override
	public String toString() {
		return "Compra";
	}	
	
}