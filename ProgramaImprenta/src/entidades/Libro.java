package entidades;

import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Libro extends Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numLibros = 0;
	private long idLibro;
	private String colorTapa; // para saber el color de su tapa
	private int numCopias; // el numero de copias es entero
	private Trabajo[] idTrabajo;
	private Trabajo[] idCliente;
	
//Constructor por defecto de la clase Libro
	public Libro() {
		super();
		numLibros = numLibros + 1;
		this.idLibro = numLibros;

	}

	public static Libro nuevoLibro() {
		Libro ret = new Libro();
		Scanner teclado = new Scanner (System.in);
		long id = -1;
		boolean validId = false; 
		do {
			System.out.println("introduce un id mayor que 0");
			id = teclado.nextLong();
			validId = validador.validarId(id);
		} while (!validId);
		ret.setIdLibro(id);
		String color=" ";
		boolean validacolor= false;
		do {
			System.out.println("Introduce el color de la tapa ( mas de 4 letras y menos de 10)");
			color = teclado.nextLine();
			validacolor= validador.validarColorTapa(color);
		} while (!validacolor);
		ret.setColorTapa(color);
		int numcopias = -1;
		boolean validacopias= false;
		do {
			System.out.println("introduce un numero de copias (mayor que 0 )");
			numcopias = teclado.nextInt();
			validacopias = validador.validarnumcopias(numcopias);
		} while (!validacopias);
		ret.setNumCopias(numcopias);

		String tipo ="";
		boolean validatipo = false;
		do {
			System.out.println("introduce un tipo de relieve ( mas de 4 letras y menos de 10)");
			tipo = teclado.nextLine();
			validatipo = validador.validarTipoRelieve(tipo);
		} while (!validatipo);
		ret.setTipoRelieve(tipo);
		return ret;
	}

	public Libro(long idLibro, String colorTapa, int numCopias) {
		super();
		numLibros = numLibros + 1;
		this.idLibro = numLibros;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el colorTapa:");
		colorTapa = teclado.nextLine();
		setColorTapa(colorTapa);

		Scanner teclado1 = new Scanner(System.in);
		System.out.println("Introduce el numcopias:");
		numCopias = teclado1.nextInt();
		setColorTapa(colorTapa);

		Scanner teclado2 = new Scanner(System.in);
		System.out.println("Introduce el tipoRelieve:");
		tipoRelieve = teclado2.nextLine();
		setColorTapa(tipoRelieve);
	}

//Constructor con atributos de la superclase Trabajo
	public Libro(long idLibro, String colorTapa, int numCopias, long idTrabajo, int fechaSolicitud,
			int fechaEntrega, String tipoRelieve) {
		super(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve, null, null);

	}

	// Conatructor con atributos de la clase Libro y la superclase Trbajo
	public Libro(long idLibro, String colorTapa, int numCopias, int fechaSolicitud,
			int fechaEntrega, String tipoRelieve, Trabajo idTrabajo, Trabajo idCliente) {
		super();
		numLibros = numLibros + 1;
		this.idLibro = numLibros;
		this.colorTapa = colorTapa;
		this.numCopias = numCopias;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaEntrega = fechaEntrega;
		this.tipoRelieve = tipoRelieve;
	}

	public static int getNumLibros() {
		return numLibros;
	}

	public static void setNumLibros(int numLibros) {
		Libro.numLibros = numLibros;
	}

	public long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}

	public String getColorTapa() {
		return colorTapa;
	}

	public void setColorTapa(String colorTapa) {
		this.colorTapa = colorTapa;
	}

	public int getNumCopias() {
		return numCopias;
	}

	public void setNumCopias(int numCopias) {
		this.numCopias = numCopias;
	}

	public Trabajo[] getidTrabajo() {
		return idTrabajo;
	}

	public void setidTrabajo(Trabajo[] idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public Trabajo[] getididCliente() {
		return idCliente;
	}

	public void setidCliente(Trabajo[] idCliente) {
		this.idCliente = idCliente;
	}
	
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", colorTapa=" + colorTapa + ", numCopias=" + numCopias + ", "
				+ "idTrabajo=" + Arrays.toString(idTrabajo) + "idCliente=" + Arrays.toString(idCliente) + "]";
	}

}