package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Alquileres {
	private List<Alquileres> alquileres;
	
	public Alquileres() {
		alquileres = new ArrayList<Alquileres>();
}
	public List<Alquileres> get(){
		return alquileres;
		
	}
	public List<Alquileres> get(Cliente cliente){
		return alquileres;
		
	}
	public List<Alquileres> get(Vehiculo turismo){
		return alquileres;
	}
	public int getCantidad() {
		return alquileres.size();

		
	}
	public void insertar (Alquileres alquiler) {
		if (alquiler != null && !alquileres.contains(alquiler)) {
			alquileres.add(alquiler);
		}
	}
	private void comprobarAlquiler(Cliente cliente,Vehiculo turismo,LocalDate fechaAlquiler) {
		
	}
	public void devolver(Cliente cliente,LocalDate fechaDevolucion) {
		
	}
	public void borrar(Alquiler alquiler) {
		alquileres.remove(alquiler);
	}
	public Alquiler buscar(Alquiler alquiler) {
		Alquiler resultadoBusqueda = null;
		for (Alquileres busquedaAlquiler : alquileres) {
			if (busquedaAlquiler.get(Cliente.getClienteConDni(busquedaAlquiler)).equals(alquiler.getCliente())) {
				resultadoBusqueda = new Alquiler(busquedaAlquiler);
			}
		}
		return resultadoBusqueda;
		
	}
	
	

}
