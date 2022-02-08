package entidades;

import java.util.Arrays;
import java.util.Scanner;

//import utils.Datos;
import validacion.validador;

public class Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numTrabajos = 0;
	// valor mínimo 1
	protected long idTrabajo;
	protected int fechaSolicitud;
	protected int fechaEntrega;
	// mínimo 3 caracteres, máximo 25
	protected String tipoRelieve;
	protected Cliente[] idCliente;
	protected Maquina[] idMaquina;

	public Cliente[] getCliente() {
		return idCliente;
	}

	public void setClientes(Cliente[] idCliente) {
		this.idCliente = idCliente;
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

		return ret;

	}

//	public static void mostrarTrabajo() {
//		System.out.println("Lista de trabajos disponibles");
//		for (int i = 0; i < Datos.numTrabajos; i++) {
//			Trabajo t = Datos.TRABAJOS[i];
//			System.out.println(t);
//		}
//	}

//Constructor por atributos de Trabajo	
	public Trabajo(long idTrabajo, int fechaSolicitud, int fechaEntrega, String tipoRelieve, Cliente idCliente,
			Maquina idMaquina) {
		numTrabajos = numTrabajos + 1;
		this.idTrabajo = numTrabajos;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaEntrega = fechaEntrega;
		this.tipoRelieve = tipoRelieve;
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

	public int getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(int fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public int getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(int fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getTipoRelieve() {
		return tipoRelieve;
	}

	public void setTipoRelieve(String tipoRelieve) {
		this.tipoRelieve = tipoRelieve;
	}

	@Override
	public String toString() {
		return "Trabajo [idTrabajo=" + idTrabajo + ", fechaSolicitud=" + fechaSolicitud + ", fechaEntrega="
				+ fechaEntrega + ", tipoRelieve=" + tipoRelieve + ", clientes=" + Arrays.toString(idCliente)
				+ ", idMaquina=" + Arrays.toString(idMaquina) + "]";
	}

}