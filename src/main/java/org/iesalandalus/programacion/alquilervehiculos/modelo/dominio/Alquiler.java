package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Vehiculos;

public class Alquiler {
	static final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA=20;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Vehiculo vehiculo;
	
	public Alquiler(Cliente cliente,Vehiculo vehiculo,LocalDate fechaAlquiler) {
	
		setCliente(cliente);
		setVehiculo(vehiculo);
		setFechaAlquiler(fechaAlquiler);
	}
	
	public Alquiler (Alquiler alquiler) {
		if (alquiler==null) {
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}
		setCliente(new Cliente(alquiler.cliente.getNombre(), alquiler.cliente.getDni(), alquiler.cliente.getTelefono()));
		setVehiculo(Vehiculo.copiar (alquiler.vehiculo.getMarca(), alquiler.vehiculo.getModelo(),alquiler.vehiculo.getMatricula()));
		setFechaAlquiler(alquiler.fechaAlquiler);
		setFechaDevolucion(alquiler.fechaDevolucion);
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	private void setCliente (Cliente cliente) {
		if (cliente==null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
	this.cliente = cliente;
		
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	private void setVehiculo(Vehiculo vehiculo) {
		if (vehiculo==null) {
			throw new NullPointerException("ERROR: El vehículo no puede ser nulo.");
		}
		this.vehiculo = vehiculo;
	}
	public LocalDate getFechaAlquiler() {
		
		return fechaAlquiler;
	}

	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		if (fechaAlquiler==null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		if (fechaAlquiler.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		}
		this.fechaAlquiler = fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion==null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		
		if (fechaDevolucion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		if (this.fechaDevolucion!= null) {
			throw new IllegalArgumentException("ERROR: La devolución ya estaba registrada.");
		}
		this.fechaDevolucion = fechaDevolucion;
	}
	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
		
		if (getFechaDevolucion()!=null) {
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		}
		else {
			setFechaDevolucion(fechaDevolucion);
		}
		
		
		this.fechaDevolucion = fechaDevolucion;
		
	}
	public int getPrecio() {
		int factorPrecio=0;
		int precioDia=20;
		int numDias = Period.between(fechaAlquiler, fechaDevolucion).getDays();
		if (vehiculo instanceof Turismo) {
			factorPrecio=vehiculo.getFactorPrecio();
		}
		else if (vehiculo instanceof Furgoneta) {
			factorPrecio=vehiculo.getFactorPrecio();
		}
		else if (vehiculo instanceof Autobus) {
			factorPrecio=vehiculo.getFactorPrecio();
		}
	
		return (precioDia+factorPrecio)*numDias;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, fechaDevolucion, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(fechaDevolucion, other.fechaDevolucion) && Objects.equals(turismo, other.turismo);
	}

	
	
	@Override
    public String toString() {
        String cadena = null;
        if (getFechaDevolucion() == null) {
            cadena = String.format("%s <---> %s, %s - Aún no devuelto (%s€)", cliente, turismo,
                    getFechaAlquiler().format(FORMATO_FECHA), getPrecio());
        } else {
            cadena = String.format("%s <---> %s, %s - %s (%s€)", cliente, turismo,
                    getFechaAlquiler().format(FORMATO_FECHA), getFechaDevolucion().format(FORMATO_FECHA), getPrecio());
        }
        return cadena;

    }
	
	
	
	
}
