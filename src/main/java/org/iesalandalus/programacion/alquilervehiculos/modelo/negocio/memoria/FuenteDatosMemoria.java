package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IAlquileres;

public class FuenteDatosMemoria {
	
	private IClientes cliente;
	private IVehiculos vehiculo;
	private IAlquileres alquiler;
	
	
	
	
	
	
	public protect ICliente crearClientes(); {
		return new Cliente;
	} 
	
	
	
	public protect Ivehiculos crearVehiculos() {
		return new Vehiculo;
	}
	
	public protect IAlquileres crearAlquileres() {
		return new Alquiler;
	}
	
	
}
