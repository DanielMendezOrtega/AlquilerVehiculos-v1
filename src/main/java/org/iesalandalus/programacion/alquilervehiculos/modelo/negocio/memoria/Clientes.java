package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {
	private List<Cliente> clientes;

	public Clientes() {
		clientes = new ArrayList<Cliente>();

	}

	public List<Cliente> get() {
		return clientes;

	}

	public int getCantidad() {
		return clientes.size();

	}

	public void insertar(Cliente cliente) {
		if (cliente != null && !clientes.contains(cliente)) {
			clientes.add(cliente);
		}
	}

	public Cliente buscar(Cliente cliente) {
		Cliente resultadoBusqueda = null;
		for (Cliente clienteBuscado : clientes) {
			if (clienteBuscado.getDni().equals(cliente.getDni())) {
				resultadoBusqueda = new Cliente(clienteBuscado);
			}
		}
		return resultadoBusqueda;
	}

	public void borrar(Cliente cliente) {
		clientes.remove(cliente);

	}

	public void modificar(Cliente cliente, String nombre, String telefono) {
		Cliente modificado = buscar(cliente);
		modificado.setNombre(nombre);
		modificado.setTelefono(telefono);

	}

}
