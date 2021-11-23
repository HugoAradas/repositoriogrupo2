package entidades;

import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class OpCalidad extends Operario {
	// Variable para asignar el id automaticamente
	public static int numPol = 0;
	protected long NombrePolitica;
	// multiplicidad varios a varios, OperarioCalidad y PoliticaCalidad
	private PoliticaCalidad[] politica;

	// Constructor por defecto del Operario de Calidad
	public OpCalidad() {
		super();
		numPol = numPol + 1;
		this.NombrePolitica = numPol;
	}

	public static OpCalidad nuevoOpCalidad() {

		OpCalidad ret = new OpCalidad();
		Scanner teclado = new Scanner(System.in);
		long id= -1;
		boolean validaid = false;
		do {
			System.out.println("introduce un id del operario de calidad (>0)");
			id = teclado.nextLong();
			validaid = validador.validarId(id);
		} while (!validaid);
		ret.setIdOperario(id);
		String NombrePolitica = " ";
		boolean validanombre= false;
		do {
			System.out.println("Introdocue el nombre de la política (<6 y > 14 palabras)");
			NombrePolitica = teclado.next();
			validanombre = validador.validapolitica(NombrePolitica);
		} while (!validanombre);
		ret.setNombrePolitica(id);
		return ret;
	}

	// Constructor del Operario de Calidad unicamente con atributo de la superclase
	// operario
	public OpCalidad(long idOperario, String NIF, String nombreApellido, long num_telefono, String direccion,
			boolean senior, char departamento) {
		super(idOperario, NIF, nombreApellido, num_telefono, direccion, senior, departamento);

	}

	// Constructor por atributos del Operario de Calidad y la superclase Operario,
	// con los valores obligatorios parq crear un Operario de Calidad
	public OpCalidad(long idOperario, String NIF, String nombreApellido, long NombrePolitica) {
		super();
		numPol = numPol + 1;
		this.NombrePolitica = numPol;
	}

	public String toString() {
		return "OpPolitica [NombrePolitica=" + NombrePolitica + ", politica=" + Arrays.toString(politica) + "]";
	}

	public long getNombrePolitica() {
		return NombrePolitica;
	}

	public void setNombrePolitica(long NombrePolitica) {
		this.NombrePolitica = NombrePolitica;
	}

	public static int getNumPol() {
		return numPol;
	}

	public static void setNumPol(int numPol) {
		OpCalidad.numPol = numPol;
	}

	public PoliticaCalidad[] getpolitica() {
		return politica;
	}

	public void setPoliticaCalidad(PoliticaCalidad[] politica) {
		this.politica = politica;
	}
}
