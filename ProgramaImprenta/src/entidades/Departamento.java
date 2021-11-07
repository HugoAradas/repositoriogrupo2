package entidades;

import java.util.Arrays;
import java.util.Scanner;

public class Departamento {
	private Lote[] lotes;
	private Operario[] Operarios;
	private char Lugardep;

	public static Departamento nuevoDepartamento() {
		Departamento ret = new Departamento();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el LugarDeps:");
		ret.Lugardep = teclado.nextLine().charAt(0);
		ret.setLugardep(ret.Lugardep);
		return ret;

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

	public String toString() {
		return "Departamento [lotes=" + Arrays.toString(lotes) + ", Operarios=" + Arrays.toString(Operarios)
				+ ", Lugardep=" + Lugardep + "]";
	}

}
