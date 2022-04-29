package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Poster extends Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numPoster = 0;
	private long idPoster;
	private double ancho; // dado que nos pide que es en centimetros
	private double alto; // lo mismo
	private int numCopiasPoster; // El número de copias es entero
	private Trabajo[] idTrabajo;
	private Cliente[] idCliente;

//Constructor por defecto de la clase Póster
	public Poster() {
		super();
		numPoster = numPoster + 1;
		this.idPoster = numPoster;

	}

	public static Poster nuevoPoster() {
		Poster ret = new Poster();
		Scanner teclado = new Scanner(System.in);
		long idPoster = -1;
		boolean validaid = false;
		do {
			System.out.println("El id del cliente tiene que ser siempre mayor que cero");
			idPoster = teclado.nextLong();
			validaid = validador.validarId(idPoster);

		} while (!validaid);
		ret.setIdPoster(idPoster);

		// la medida del poster esta en metros el ancho y el alto
		double ancho = 0.00;
		boolean validaancho = false;
		do {
			System.out.println("introduce un ancho de menor de 100 metros");
			ancho = teclado.nextDouble();
			validaancho = validador.validaancho(ancho);
		} while (!validaancho);
		ret.setAncho(ancho);
		double alto = 0.00;
		boolean validaalto = false;
		do {
			System.out.println("introduce un alto de menor de 100 metros");
			alto = teclado.nextDouble();
			validaalto = validador.validaralto(ancho);
		} while (!validaalto);
		ret.setAncho(alto);
		int numcopias = -1;
		boolean validacopias = false;
		do {
			System.out.println("introduce un numero de copias mayor que 0");
			numcopias = teclado.nextInt();
			validacopias = validador.validarnumcopias(numcopias);
		} while (!validacopias);
		ret.setNumCopiasPoster(numcopias);

		return ret;

	}

	public Poster(long idPoster, double ancho, double alto, int numCopiasPoster) {
		super();
		numPoster = numPoster + 1;
		this.idPoster = numPoster;

	}

//Constructor por atributos de la clase Trabajo
	public Poster(long idPoster, double ancho, double alto, int numCopiasPoster, long idTrabajo,
			LocalDate fechaSolicitud, LocalDate fechaEntrega, String tipoRelieve, Cliente idCliente,
			Maquina idMaquina) {
		super(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve, idCliente, idMaquina);

	}

//Constructor con atributos de la clase póster y la superclase Trabajo
	public Poster(long idPoster, double ancho, double largo, int numCopiasPoster, int fechaSolicitud, int fechaEntrega,
			String tipoRelieve, Trabajo idTrabajo, Cliente idCliente) {
		super();
		numPoster = numPoster + 1;
		this.idPoster = numPoster;
	}

	public static int getNumPoster() {
		return numPoster;
	}

	public static void setNumPoster(int numPoster) {
		Poster.numPoster = numPoster;
	}

	public long getIdPoster() {
		return idPoster;
	}

	public void setIdPoster(long idPoster) {
		this.idPoster = idPoster;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public int getNumCopiasPoster() {
		return numCopiasPoster;
	}

	public void setNumCopiasPoster(int numCopiasPoster) {
		this.numCopiasPoster = numCopiasPoster;
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
		return idPoster + "|" + ancho + "|" + alto + "|" + numCopiasPoster + "|" + idTrabajo + "|" + idCliente;
	}

}