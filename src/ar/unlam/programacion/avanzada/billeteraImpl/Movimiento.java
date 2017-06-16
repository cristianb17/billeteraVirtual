package ar.unlam.programacion.avanzada.billeteraImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import ar.unlam.programacion.avanzada.model.Compra;
import ar.unlam.programacion.avanzada.model.Efectivo;
import ar.unlam.programacion.avanzada.model.MedioPago;
import ar.unlam.programacion.avanzada.model.Pago;
import ar.unlam.programacion.avanzada.model.Tarjeta;

public class Movimiento {
	public static final String COMPRA = "COMPRA";
	public static final String PAGO = "PAGO";
	public static final String TARJETA = "TARJETA";
	public static final String EFECTIVO = "EFECTIVO";
	private Float monto;
	private TipoMovimiento movimiento;
	private Date fecha;
	private String descripcion;
	private MedioPago medioDePago;
	
	public Movimiento() {
	}
	
	public Movimiento(Float monto, String movimiento, String descripcion, String medioDePago, Date fecha) {
		this.monto = monto;
		this.movimiento = obtenerMovimiento(movimiento);
		this.descripcion = descripcion;
		this.medioDePago = obtenerMedioPago(medioDePago);
		this.fecha = fecha;
	}

	private TipoMovimiento obtenerMovimiento(String movimiento) {
		TipoMovimiento tipoMov = null;
		
		if(movimiento.toUpperCase().equals(PAGO)) {
			tipoMov = new Pago();
		}else if(movimiento.toUpperCase().equals(COMPRA)){
			tipoMov = new Compra();
		}else {
			System.out.println("Error no se reconoce movimiento");
		}
		return tipoMov;
	}
	
	
	private MedioPago obtenerMedioPago(String medioPagoIngresado){
		if(medioPagoIngresado.toUpperCase().equals(TARJETA)) {
			medioDePago = new Tarjeta();
		}else if(medioPagoIngresado.toUpperCase().equals(EFECTIVO)){
			medioDePago = new Efectivo();
		}else {
			System.out.println("Error no se reconoce medio de pago");
		}
		
		return medioDePago;
	}

	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	public TipoMovimiento getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(TipoMovimiento movimiento) {
		this.movimiento = movimiento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public MedioPago getMedioDePago() {
		return medioDePago;
	}
	public void setMedioDePago(MedioPago medioDePago) {
		this.medioDePago = medioDePago;
	}

	@Override
	public String toString() {
                 SimpleDateFormat dt = new SimpleDateFormat("dd.mm.yyyy"); 
		return monto + ", movimiento=" + movimiento.toString() + ", fecha=" + dt.format(fecha) + ", descripcion="
				+ descripcion + ", medioDePago=" + medioDePago;
	}

}
