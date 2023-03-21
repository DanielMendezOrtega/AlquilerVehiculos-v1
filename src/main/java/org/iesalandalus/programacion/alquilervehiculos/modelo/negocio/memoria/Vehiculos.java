package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Vehiculos extends Vehiculo {
	private static final int FACTOR_CILINDRADA=10;
	private static int cilindrada;
	
	public Vehiculos(String marca,String modelo, int cilindrada,String matricula) {
		super(marca,modelo,matricula);
		setCilindrada(cilindrada);
		
	}
	public Vehiculos(Vehiculos turismo) {
		super(turismo);
		if(turismo==null) { 
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
	
		this.cilindrada = turismo.cilindrada;
		
		
	}
	public static int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		if (cilindrada <=0 || cilindrada>5000) {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		
		this.cilindrada = cilindrada;
	}

	@Override
	protected int getFactorPrecio() {
		
		return cilindrada/FACTOR_CILINDRADA;
		
	}
	@Override
	public String toString() {
		return Vehiculo.marca +" " + Vehiculo.modelo + " "+"("+ cilindrada+"CV"+")" +" "+ "-"+" " + Vehiculo.matricula;
				
	}

}
