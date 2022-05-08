package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Libro extends Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numLibros = 0;
	private long idLibro;
	private String colorTapa; // para saber el color de su tapa
	private int numCopiasLibro; // el numero de copias es entero
	private long idTrabajo;
	private long idCliente;

//Constructor por defecto de la clase Libro
	public Libro() {
		this.idLibro = numLibros;
	}

	public Libro(long idLibro, String colorTapa, int numCopias, Cliente idCliente, Trabajo idTrabajo) {
		super();
		this.idLibro = idLibro;
		this.colorTapa = colorTapa;
		this.numCopiasLibro = numCopias;
	}

	public Libro(long idLibro, String colorTapa, int numCopias, Cliente idCliente, long idTrabajo,
			LocalDate fechaSolicitud, LocalDate fechaEntrega, String tipoRelieve, Maquina idMaquina) {
		super(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve, idCliente, idMaquina);
		this.idLibro = idLibro;
		this.colorTapa = colorTapa;
		this.numCopiasLibro = numCopias;
	}

	public static Libro nuevoLibro() {
		Libro ret = null;
		Scanner teclado = new Scanner(System.in);
		long id = -1;
		Trabajo idTrabajo = null;
		Cliente idCliente = null;

		boolean validId = false;
		do {
			System.out.println("introduce un id mayor que 0");
			id = teclado.nextLong();
			validId = validador.validarId(id);
		} while (!validId);
		String color = " ";
		boolean validacolor = false;
		do {
			System.out.println("Introduce el color de la tapa ( mas de 4 letras y menos de 10)");
			color = teclado.nextLine();
			validacolor = validador.validarColorTapa(color);
		} while (!validacolor);
		int numcopias = -1;
		boolean validacopias = false;
		do {
			System.out.println("introduce un numero de copias (mayor que 0 )");
			numcopias = teclado.nextInt();
			validacopias = validador.validarnumcopias(numcopias);
		} while (!validacopias);

		System.out.println("introduce el trabajo para realizar el libro");
		idTrabajo = Trabajo.nuevoTrabajo();

		System.out.println("introduce el cliente que quiere el libro");
		idCliente = Cliente.nuevoCliente();

		ret = new Libro(id, color, numcopias, idCliente, idTrabajo);
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
	public Libro(long idLibro, String colorTapa, int numCopias, long idTrabajo, LocalDate fechaSolicitud,
			LocalDate fechaEntrega, String tipoRelieve, Cliente idCliente, Maquina idMaquina) {
		super(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve, idCliente, idMaquina);

	}

// Conatructor con atributos de la clase Libro y la superclase Trbajo
	public Libro(long idLibro, String colorTapa, int numCopias, int fechaSolicitud, int fechaEntrega,
			String tipoRelieve, Trabajo idTrabajo, Cliente idCliente) {
		super();
		numLibros = numLibros + 1;
		this.idLibro = numLibros;
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
		return numCopiasLibro;
	}

	public int getNumCopiasLibro() {
		return numCopiasLibro;
	}

	public void setNumCopiasLibro(int numCopiasLibro) {
		this.numCopiasLibro = numCopiasLibro;
	}

	public long getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(long idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public void setNumCopias(int numCopias) {
		this.numCopiasLibro = numCopias;
	}

	public long getidTrabajo() {
		return idTrabajo;
	}

	public void setidTrabajo(long idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public long getidCliente() {
		return idCliente;
	}

	public void setidCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String toString() {
		return idLibro + "|" + colorTapa + "|" + numCopiasLibro + "|" + idTrabajo + "|" + idCliente;
	}

}