package entidades;

import java.util.Arrays;

public class OpMaquina extends Operario {
	// Variable auxiliar para asignar el id automaticamente
	public static int numLabores = 0;
	// multiplicidad varios a varios, operarios de maquinas y labores de mantenimiento
	private LaboresMantenimiento[] labores;

//Constructor por defecto del Operario de máquinas
	public OpMaquina() {
		super();
		numLabores = numLabores + 1;
	}

//Constructor del Operario de máquinas únicamente con atributo de la superclase operario
	public OpMaquina(long idOperario, String NIF, String nombreApellido, long num_telefono, String direccion,
			boolean senior, char departamento) {
		super(idOperario, NIF, nombreApellido, num_telefono, direccion, senior, departamento);

	}

//Constructor por atributos del Operario de máquina y la superclase Operario, con los valores obligatorios parq crear un Operario de máquinas
	public OpMaquina(long idOperario, String NIF, String nombreApellido, long idLabor) {
		super();
		numLabores = numLabores + 1;
	}

	@Override
	public String toString() {
		return "OpMaquina [labores=" + Arrays.toString(labores) + "]";
	}

	public static int getNumLabores() {
		return numLabores;
	}

	public static void setNumLabores(int numLabores) {
		OpMaquina.numLabores = numLabores;
	}
	
	public LaboresMantenimiento[] getLabores() {
		return labores;
	}

	public void setLabores(LaboresMantenimiento[] labores) {
		this.labores = labores;
	}

}
