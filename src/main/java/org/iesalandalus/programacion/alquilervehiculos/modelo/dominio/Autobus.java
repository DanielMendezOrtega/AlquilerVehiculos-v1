package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Autobus extends Vehiculo  {
	private static final int FACTOR_PLAZAS=10;
	private static int plazas;
	private int autobus;
	
	
	public Autobus(String marca,String modelo, int plazas,String matricula) {
		super(marca,modelo,matricula);
		setPlazas(plazas);
		
	}
	public Autobus(Autobus autobus) {
		super(autobus);
		if(autobus==null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
	
		this.autobus = autobus.plazas;
		
		
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		if (plazas <=7 || plazas>100) {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		
		this.plazas = plazas;
	}

	@Override
	protected int getFactorPrecio() {
		
		return plazas*FACTOR_PLAZAS;
		
	}
	@Override
	public String toString() {
		return Vehiculo.marca +" " + Vehiculo.modelo + " "+"("+ plazas+"CV"+")" +" "+ "-"+" " + Vehiculo.matricula;
				
	}



	

}
