package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.ArrayList;
import java.util.List;

public  class Turismo extends Vehiculo {
	private static final int FACTOR_CILINDRADA=10;
	private int cilindrada=0;
	private int turismo;
	
	public Turismo(String marca ,String modelo, int cilindrada, String matricula) {
		super(marca,modelo,matricula);
		setCilindrada(cilindrada);
	}
	
	public Turismo(Turismo turismo) {
		super(turismo);
		if(turismo==null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
	
		this.turismo = turismo.cilindrada;
		
	}
		public int getCilindrada() {
			return cilindrada;
		}
		public void setCilindrada(int cilindrada) {
			if (cilindrada <=0 || cilindrada>5000) {
				throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
			}
			
			this.cilindrada = cilindrada;
		}
		
		public int getFactorPrecio() {
			return cilindrada/FACTOR_CILINDRADA;
		}

		@Override
		public String toString() {
			return "Turismo [cilindrada=" + cilindrada + "]";
		}
		
		
		
		
}		


