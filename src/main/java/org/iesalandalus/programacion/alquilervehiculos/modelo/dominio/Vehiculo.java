package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Vehiculos;

public abstract class Vehiculo {

	private static final String ER_MARCA = ("(^[A-Z][a-z]+)|(^[A-Z][a-z]+\s[A-Z][a-z]+)|(^[A-Z]+)|(^[A-Z][a-z]+-[A-Z][a-z]+)|(^[A-Z][a-z]+[A-Z][a-z]+)");
	private static final String ER_MATRICULA = ("^\\d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}");
	protected static   String marca;
	protected static  String modelo;
	protected static  String matricula;
	
	protected Vehiculo(String marca,String modelo,String matricula) {
		super();
		setMarca(Vehiculo.marca);
		setModelo(Vehiculo.modelo);
		setMatricula(Vehiculo.matricula);
	}
	protected Vehiculo(Vehiculo vehiculo) {
		
		if(vehiculo==null) {
			throw new NullPointerException("ERROR: No es posible copiar un vehiculo nulo.");
		}
		Vehiculo.marca=vehiculo.getMarca();
		Vehiculo.modelo=vehiculo.getModelo();
		Vehiculo.matricula=vehiculo.getMatricula();
		
	}
	
	
	public static Vehiculo copiar (Vehiculo vehiculo) {
		Vehiculo vehiculoCopiado=null;
		if (vehiculo instanceof Vehiculos turismo) {
			vehiculoCopiado= new Vehiculos(turismo);
		}
		if (vehiculo instanceof Autobus autobus) {
			vehiculoCopiado= new Autobus(autobus);
		}
		if (vehiculo instanceof Furgoneta furgoneta) {
			vehiculoCopiado= new Furgoneta(furgoneta);
		}
		return vehiculoCopiado;
	}
	public static Vehiculo getVehiculoConMatricula(String matricula) {
		return new Vehiculos("Seat","Leon" , 90, matricula);
		
	}
	protected abstract int getFactorPrecio();


	public String getMarca() {
		return marca;
	}

	private void setMarca(String marca) {
		if(marca==null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		if (!marca.matches(ER_MARCA)) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		
		Vehiculo.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	private void setModelo(String modelo) {
		if ( modelo==null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (modelo.isBlank()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
			Vehiculo.modelo = modelo;
		
		
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMatricula(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		Vehiculo.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula); 
	}
	


}