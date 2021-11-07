package entidades;

import java.time.LocalDate;

import java.util.Scanner;


public class Libro extends Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numLibros = 0;
	private long idLibro; 
	private String colorTapa; // para saber el color de su tapa 
	private int numCopias; // el numero de copias es entero 

//Constructor por defecto de la clase Libro
	public Libro() {
		super();
		numLibros = numLibros + 1;
		this.idLibro = numLibros;

	}
	
	public Libro(long idLibro, String colorTapa, int numCopias) {
		super();
		numLibros = numLibros + 1;
		this.idLibro = numLibros;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el colorTapa:");
		colorTapa=teclado.nextLine();
		setColorTapa(colorTapa);
		
		Scanner teclado1 = new Scanner(System.in);
		System.out.println("Introduce el numcopias:");
		numCopias=teclado1.nextInt();
		setColorTapa(colorTapa);
		
		Scanner teclado2 = new Scanner(System.in);
		System.out.println("Introduce el tipoRelieve:");
		tipoRelieve=teclado2.nextLine();
		setColorTapa(tipoRelieve);
	}

//Constructor con atributos de la superclase Trabajo
	public Libro(long idTrabajo, LocalDate fechaSolicitud, LocalDate fechaEntrega, String tipoRelieve) {
		super(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve);

	}

	// Conatructor con atributos de la clase Libro y la superclase Trbajo
	public Libro(long idLibro, String colorTapa, int numCopias, long idTrabajo, LocalDate fechaSolicitud,
			LocalDate fechaEntrega, String tipoRelieve) {
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
		return numCopias;
	}

	public void setNumCopias(int numCopias) {
		this.numCopias = numCopias;
	}

	public String toString() {
		return "Libro [idLibro=" + idLibro + ", colorTapa=" + colorTapa + ", numCopias=" + numCopias + "]";
	}

}