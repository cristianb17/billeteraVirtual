package ar.unlam.programacion.avanzada.billeteraImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Billetera {
	private List<Movimiento> movimientos;
	private float montoTotalGastos;
	private float montoTotalDineroDisponible;
	
	public Billetera() {
		movimientos = new ArrayList<Movimiento>();
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	
	public float obtenerSaldosGastos(){
		for(Movimiento movimiento : movimientos) {
			montoTotalGastos += movimiento.getMonto();
		}
		System.out.println("el montoTotal de los gastos son : " + montoTotalGastos);
		return montoTotalGastos;
	}
	
	public float obtenerDineroDisponible(){
		System.out.println("el montoTotal del dinero disponible es : " + montoTotalDineroDisponible);
		return montoTotalDineroDisponible;
	}
	
	public void agregarMovimiento(String descripcion, float monto, String medioPago, String tipoMovimiento){
		
		if(montoTotalDineroDisponible >= monto) {
			montoTotalDineroDisponible = montoTotalDineroDisponible - monto;
			System.out.println("se ha agregado el movimiento : " + tipoMovimiento + ", se realizo la operacion de: " + descripcion + ", por un saldo de : " + monto);
			Movimiento movimiento = new Movimiento(monto, tipoMovimiento, descripcion, medioPago, new Date());
			this.movimientos.add(movimiento);
		} else {
			System.out.println("no hay dinero suficiente para agregar el movimiento : " + descripcion + ", con un monto : " + monto + ", dinero disponible : " + montoTotalDineroDisponible);
		}
	}
        
        
	
	public void setMontoTotalDineroDisponible(float montoTotalDineroDisponible) {
		this.montoTotalDineroDisponible = montoTotalDineroDisponible;
	}

	@Override
	public String toString() {
		return "Billetera [movimientos=" + movimientos + ", montoTotalGastos=" + montoTotalGastos
				+ ", montoTotalDineroDisponible=" + montoTotalDineroDisponible + "]";
	}

     public float getMontoTotalGastos() {
        return montoTotalGastos;
    }
     
    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    public float getMontoTotalDineroDisponible() {
        return montoTotalDineroDisponible;
    }
}
