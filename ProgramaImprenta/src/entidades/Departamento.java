package entidades;

import java.util.Arrays;

public class Departamento {
	private Lote[] lotes;
	private Operario[] Operarios;
	private char Lugardep;

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
		return Lugardep;
	}

	public void setLugardep(char lugardep) {
		Lugardep = lugardep;
	}

	@Override
	public String toString() {
		return "Departamento [lotes=" + Arrays.toString(lotes) + ", Operarios=" + Arrays.toString(Operarios)
				+ ", Lugardep=" + Lugardep + "]";
	}

}
