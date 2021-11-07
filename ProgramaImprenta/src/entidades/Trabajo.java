package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numTrabajos = 0;
	protected long idTrabajo;
	protected LocalDate fechaSolicitud;
	protected LocalDate fechaEntrega;
	protected String tipoRelieve;
	private Cliente[] clientes;

	// Constructor por defecto de la clase Trabajo
	public Trabajo() {
		numTrabajos = numTrabajos + 1;
		this.idTrabajo = numTrabajos;
	}
	public static Trabajo nuevoTrabajo() {
		numTrabajos = numTrabajos + 1;
		Trabajo ret = new Trabajo();
		ret.idTrabajo= numTrabajos;
		Scanner teclado = new Scanner (System.in);
		System.out.println("Dume la fecha que se solicito el trabajo");
		ret.tipoRelieve = teclado.nextLine();
		ret.setTipoRelieve(ret.tipoRelieve);
		
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

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Trabajo [idTrabajo=" + idTrabajo + ", fechaSolicitud=" + fechaSolicitud + ", fechaEntrega="
				+ fechaEntrega + ", tipoRelieve=" + tipoRelieve + ", clientes=" + Arrays.toString(clientes) + "]";
	}

}