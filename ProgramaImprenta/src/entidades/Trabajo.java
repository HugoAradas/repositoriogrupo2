package entidades;

import validacion.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numTrabajos = 0;
	// valor mínimo 1
	protected long idTrabajo;
	protected LocalDate fechaSolicitud;
	protected LocalDate fechaEntrega;
	// mínimo 3 caracteres, máximo 25
	protected String tipoRelieve;
	private long idClientes;
	private Cliente[] clientes;

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	// Constructor por defecto de la clase Trabajo
	public Trabajo() {
		numTrabajos = numTrabajos + 1;
		this.idTrabajo = numTrabajos;
	}

	public static Trabajo nuevoTrabajo() {
		Trabajo ret = new Trabajo();
		Scanner teclado = new Scanner(System.in);
		long idTrabajo = -1;
		boolean validaid = false;
		do {
			System.out.println("El id del trabajo tiene que ser siempre mayor que cero");
			idTrabajo = teclado.nextLong();
			validaid = validador.validarId(idTrabajo);
		} while (!validaid);
		ret.setIdTrabajo(idTrabajo);
		String tipoRelieve = "";
		boolean validarelieve = false;
		do {
			System.out.println("Introduce el tipo de relieve");
			tipoRelieve = teclado.next();
			validarelieve = validador.validarTipoRelieve(tipoRelieve);
		} while (!validarelieve);
		ret.setTipoRelieve(tipoRelieve);
		long idClientes = -1;
		boolean validacliente = false;
		do {
			System.out.println("Introduce el id del cliente que solicita el trabajo (mayor que 0) ");
			idClientes = teclado.nextLong();
			validacliente = validador.validarId(idClientes);
		} while (!validacliente);
		ret.setIdClientes(idClientes);

		return ret;

	}

//Constructor por atributos de Trabajo
	public Trabajo(long idTrabajo, LocalDate fechaTrabajo, Cliente[] clientes) {
		numTrabajos = numTrabajos + 1;
		this.idTrabajo = numTrabajos;
	}

	public Trabajo(long idTrabajo, LocalDate fechaSolicitud, LocalDate fechaEntrega, String tipoRelieve) {
		numTrabajos = numTrabajos + 1;
		this.idTrabajo = numTrabajos;

	}

	public static int getNumTrabajos() {
		return numTrabajos;
	}

	public static void setNumTrabajos(int numTrabajos) {
		Trabajo.numTrabajos = numTrabajos;

	}

	public long getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(long idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getTipoRelieve() {
		return tipoRelieve;
	}

	public void setTipoRelieve(String tipoRelieve) {
		this.tipoRelieve = tipoRelieve;
	}

	public long getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(long idClientes) {
		this.idClientes = idClientes;
	}

	@Override
	public String toString() {
		return "Trabajo [idTrabajo=" + idTrabajo + ", fechaSolicitud=" + fechaSolicitud + ", fechaEntrega="
				+ fechaEntrega + ", tipoRelieve=" + tipoRelieve + ", idClientes=" + idClientes + ", clientes="
				+ Arrays.toString(clientes) + "]";
	}

}