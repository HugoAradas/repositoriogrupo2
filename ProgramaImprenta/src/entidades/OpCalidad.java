package entidades;

import java.util.Scanner;

import validacion.validador;

public class OpCalidad extends Operario {
	protected Operario[] idOperario;

	public static OpCalidad nuevoOpCalidad() {

		OpCalidad ret = new OpCalidad();
		Scanner teclado = null;
		long id = -1;
		Operario idOperario = null;
		boolean validaid = false;
		do {
			System.out.println("introduce un id del operario de calidad (>0)");
			id = teclado.nextLong();
			validaid = validador.validarId(id);
		} while (!validaid);

		System.out.println("inroduce los datos del operario");
		idOperario = Operario.nuevoOperario();
		ret = new OpCalidad(idOperario);
		return ret;
	}

	// Constructor por defecto del Operario de Calidad
	public OpCalidad(Operario idOperario) {
		super();
	}

	// Constructor del Operario de Calidad unicamente con atributo de la superclase
	// operario
	public OpCalidad(long idOperario, String NIF, String nombre, String apellido, long num_telefono, String direccion,
			boolean senior, char idDep) {
		super(idOperario, NIF, nombre, apellido, num_telefono, direccion, senior, idDep);

	}

	// Constructor por atributos del Operario de Calidad y la superclase Operario,
	// con los valores obligatorios parq crear un Operario de Calidad
	public OpCalidad(Operario idOperario, String NIF, String nombreApellido) {
		super();
	}

	public OpCalidad() {
		super();
	}

	@Override
	public String toString() {
		return  idOperario + "|";
	}
	
	
	
}
