package entidades;

import java.util.Scanner;

import validacion.validador;

public class Rotulo extends Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numRotulos = 0;
	// valor mínimo 1
	private long idRotulo;
	// mínimo 3 caracters, máximo 25
	private String centroComercial;

//Constructor con atributos de la clase trabajo
	public Rotulo(long idTrabajo, int fechaSolicitud, int fechaEntrega, String tipoRelieve) {
		super(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve, null, null);

	}

	public static Rotulo nuevoRotulo() {
		Rotulo ret = new Rotulo();
		ret = (Rotulo) Rotulo.nuevoRotulo();
		Scanner teclado = new Scanner(System.in);
		boolean centroComercialValido = false;
		do {
			System.out.println("Introduce el centro comercial");
			ret.centroComercial = teclado.nextLine();
			centroComercialValido = validador.validarCentroComercial(ret.centroComercial);
			return ret;
		} while (!centroComercialValido);

	}

//Constructor por defecto de la clase Rótulo
	public Rotulo() {
		super();
		numRotulos = numRotulos + 1;
		this.idRotulo = numRotulos;
	}

	public Rotulo(long idRotulo, String centroComercial) {
		super();
		numRotulos = numRotulos + 1;
		this.idRotulo = numRotulos;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el centroComercial:");
		centroComercial = teclado.nextLine();
		setCentroComercial(centroComercial);

	}

//Constructor con atributos de la clase rotulo y la superclase Trabajo
	public Rotulo(long idRotulo, String centroComercial, long idTrabajo, int fechaSolicitud,
			int fechaEntrega, String tipoRelieve) {
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

	public String toString() {
		return "Rotulos [idRotulos=" + idRotulo + ", centroComercial=" + centroComercial + "]";
	}

}
