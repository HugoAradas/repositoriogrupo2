package entidades;

import java.util.Arrays;

public class OpMaquina extends Operario {
	// Variable auxiliar para asignar el id automaticamente
	protected Operario[] idOperario;

//Constructor por defecto del Operario de máquinas
	public OpMaquina() {
		super();
	}

//Constructor del Operario de máquinas únicamente con atributo de la superclase operario
	public OpMaquina(long idOperario, String NIF, String nombre, String apellido, long num_telefono, String direccion,
			boolean senior, char idDep) {
		super(idOperario, NIF, nombre, apellido, num_telefono, direccion, senior, idDep);

	}

//Constructor por atributos del Operario de máquina y la superclase Operario, con los valores obligatorios parq crear un Operario de máquinas
	public OpMaquina(Operario idOperario, String NIF, String nombre, String apellido) {
		super();
	}
	
	public Operario[] getidOperario() {
		return idOperario;
	}

	public void setidOperario(Operario[] idOperario) {
		this.idOperario = idOperario;
	}

	@Override
	public String toString() {
		return idOperario  + "|";
	}
	
}
