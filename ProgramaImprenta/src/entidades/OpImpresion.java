package entidades;

public class OpImpresion extends Operario {
	// Variable para asignar el id automaticamente
	public static int numIm = 0;
	protected long idMod;

	// Constructor por defecto del Operario de Impresion
	public OpImpresion() {
		super();
		numIm = numIm + 1;
		this.idMod = numIm;
	}

	// Constructor del Operario de Impresion unicamente con atributo de la superclase
	// operario
	public OpImpresion(long idMod, long idOperario, String NIF, String nombre, String apellido, long num_telefono, String direccion,
			boolean senior, char idDep) {
		super(idOperario, NIF, nombre, apellido, num_telefono, direccion, senior, idDep);

	}

	// Constructor por atributos del Operario de Impresion y la superclase Operario,
	// con los valores obligatorios parq crear un Operario de Impresion
	public OpImpresion(long idMod, long idOperario, String NIF, String nombreApellido) {
		super();
		numIm = numIm + 1;
		this.idMod = numIm;
	}

	public long getidMod() {
		return idMod;
	}

	public void setidMod(long idMod) {
		this.idMod = idMod;
	}

	public static int getNumIm() {
		return numIm;
	}

	public static void setNumIm(int numIm) {
		OpImpresion.numIm = numIm;
	}

	@Override
	public String toString() {
		return idMod + "|";
	}
	
}
