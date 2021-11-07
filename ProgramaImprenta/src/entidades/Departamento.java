package entidades;

import java.util.Arrays;

public class Departamento {
	private Lote[] lotes;
	private Operario[] Operarios;
	private char Lugardeps;

	public Departamento() {

	}

	public Lote[] getLotes() {
		return lotes;
	}

	public void setLotes(Lote[] lotes) {
		this.lotes = lotes;
	}

	public Operario[] getOperarios() {
		return Operarios;
	}

	public void setOperarios(Operario[] operarios) {
		Operarios = operarios;
	}

	public char getLugardep() {
		return Lugardeps;
	}

	public void setLugardep(char lugardep) {
		Lugardeps = lugardep;
	}

	@Override
	public String toString() {
		return "Departamento [lotes=" + Arrays.toString(lotes) + ", Operarios=" + Arrays.toString(Operarios)
				+ ", Lugardep=" + Lugardeps + "]";
	}

}
