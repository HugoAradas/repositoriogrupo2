package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Rotulo extends Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numRotulos = 0;
	// valor mínimo 1
	private long idRotulo;
	// mínimo 3 caracters, máximo 25
	private String centroComercial;
	private Trabajo[] idTrabajo;
	private Cliente[] idCliente;

//Constructor por defecto de la clase Rótulo
	public Rotulo() {
		super();
		numRotulos = numRotulos + 1;
		this.idRotulo = numRotulos;
	}

	public static Rotulo nuevoRotulo() {
		Rotulo ret = new Rotulo();
		Scanner teclado = new Scanner(System.in);
		long id = -1;
		boolean validId = false;
		do {
			System.out.println("introduce un id mayor que 0");
			id = teclado.nextLong();
			validId = validador.validarId(id);
		} while (!validId);
		ret.setIdRotulo(id);

		boolean centroComercialValido = false;
		do {
			System.out.println("Introduce el centro comercial");
			ret.centroComercial = teclado.nextLine();
			centroComercialValido = validador.validarCentroComercial(ret.centroComercial);
			return ret;
		} while (!centroComercialValido);

	}

	public Rotulo(long idRotulo, String centroComercial) {
		super();
		numRotulos = numRotulos + 1;
		this.idRotulo = numRotulos;

	}
	
//Constructor con atributos de la clase trabajo
	public Rotulo(long idRotulo, String centroComercial, long idTrabajo, LocalDate fechaSolicitud,
			LocalDate fechaEntrega, String tipoRelieve, Cliente idCliente, Maquina idMaquina) {
		super(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve, idCliente, idMaquina);

	}

	public Rotulo(long idRotulo, String centroComercial, int fechaSolicitud, int fechaEntrega, String tipoRelieve,
			Trabajo idTrabajo, Cliente idCliente) {
		super();
		numRotulos = numRotulos + 1;
		this.idRotulo = numRotulos;

	}

//Constructor con atributos de la clase rotulo y la superclase Trabajo
	public Rotulo(long idRotulo, String centroComercial, long idTrabajo, int fechaSolicitud, int fechaEntrega,
			String tipoRelieve) {
		super();
		numRotulos = numRotulos + 1;
		this.idRotulo = numRotulos;
	}

	public static int getNumRotulos() {
		return numRotulos;
	}

	public static void setNumRotulos(int numRotulos) {
		Rotulo.numRotulos = numRotulos;
	}

	public long getIdRotulo() {
		return idRotulo;
	}

	public void setIdRotulo(long idRotulo) {
		this.idRotulo = idRotulo;
	}

	public String getCentroComercial() {
		return centroComercial;
	}

	public void setCentroComercial(String centroComercial) {
		this.centroComercial = centroComercial;
	}

	public Trabajo[] getidTrabajo() {
		return idTrabajo;
	}

	public void setidTrabajo(Trabajo[] idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public Cliente[] getidCliente() {
		return idCliente;
	}

	public void setidCliente(Cliente[] idCliente) {
		this.idCliente = idCliente;
	}

	public String toString() {
		return idRotulo + "|" + centroComercial + "|" + idTrabajo + "|" + idCliente;
	}

}