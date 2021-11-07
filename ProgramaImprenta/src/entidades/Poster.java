package entidades;

import java.time.LocalDate;
import java.util.Scanner;

public class Poster extends Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numPoster = 0;
	private long idPoster;
	private double ancho; // dado que nos pide que es en centimetros
	private double alto; // lo mismo
	private int numCopiasPoster; // El número de copias es entero

//Constructor por defecto de la clase Póster
	public Poster() {
		super();
		numPoster = numPoster + 1;
		this.idPoster = numPoster;

	}

	public static Poster nuevoPoster() {
		Poster ret = new Poster();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el ancho del nuevo poster");
		ret.ancho = teclado.nextDouble();
		ret.setAncho(ret.ancho);
		System.out.println("Introduce el alto del nuevo poster");
		ret.alto = teclado.nextDouble();
		ret.setAlto(ret.alto);
		System.out.println("Introduce el numero de copias del nuevo poster");
		ret.numCopiasPoster = teclado.nextInt();
		ret.setNumCopiasPoster(ret.numCopiasPoster);

		return ret;

	}

	public Poster(long idPoster, double ancho, double alto, int numCopiasPoster) {
		super();
		numPoster = numPoster + 1;
		this.idPoster = numPoster;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el ancho:");
		ancho = teclado.nextDouble();
		setAncho(ancho);

		Scanner teclado1 = new Scanner(System.in);
		System.out.println("Introduce el alto:");
		ancho = teclado1.nextDouble();
		setAlto(alto);

		Scanner teclado2 = new Scanner(System.in);
		System.out.println("Introduce el ancho:");
		numCopiasPoster = teclado2.nextInt();
		setNumCopiasPoster(numCopiasPoster);

	}

//Constructor por atributos de la clase Trabajo
	public Poster(long idTrabajo, LocalDate fechaSolicitud, LocalDate fechaEntrega, String tipoRelieve) {
		super(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve);

	}

//Constructor con atributos de la clase póster y la superclase Trabajo
	public Poster(long idPoster, double ancho, double alto, int numCopiasPoster, long idTrabajo, LocalDate fechaEntrega,
			LocalDate fechaSolicitud) {
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

	public String toString() {
		return "Poster [idPoster=" + idPoster + ", ancho=" + ancho + ", alto=" + alto + ", numCopiasPoster="
				+ numCopiasPoster + "]";
	}

}