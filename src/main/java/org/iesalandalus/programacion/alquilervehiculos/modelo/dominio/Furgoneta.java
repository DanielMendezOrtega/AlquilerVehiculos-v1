package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Furgoneta extends Vehiculo {
	
	private static final int FACTOR_PMA=100;
	private static final int FACTOR_PLAZAS=1;
	private static int pma;
	private static int plazas;
	
	
	
	public Furgoneta(String marca, String modelo, int pma, int plazas, String matricula) {
		super(marca,modelo,matricula);
		setPma(pma);
		setPlazas(plazas);
	} 
	
	public Furgoneta(Furgoneta furgoneta) {
		super(furgoneta);
		if(furgoneta==null) {
			throw new NullPointerException("ERROR: No es posible copiar una furgoneta nula.");
		}
		this.pma=furgoneta.pma;
		this.plazas=furgoneta.plazas;
		
	}
	public static int getPma() {
		return pma;
	}
	private void setPma(int pma) {
		if(pma<FACTOR_PMA) {
			throw new IllegalArgumentException("ERROR, el pma no puede ser inferior a 100");
		}
		this.pma = pma;
	}
	public static int getPlazas() {
		return plazas;
	}
	private void setPlazas(int plazas) {
		if(plazas<FACTOR_PLAZAS) {
			throw new IllegalArgumentException("ERROR, las plazas no pueden ser inferior a 1");
		}
		this.plazas = plazas;
		
	}
	public int getFactorPrecio() {
		return (pma/FACTOR_PMA)+(plazas*FACTOR_PLAZAS);
	}
	@Override
	public String toString() {
		return "Furgoneta [pma=" + pma + ", plazas=" + plazas + "]";
	}
	 
	
	

}
