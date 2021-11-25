package entidades;

import java.util.Arrays;
import java.util.Scanner;

public class Departamento {
	private char Lugardep;

	public static Departamento nuevoDepartamento() {
		Departamento ret = new Departamento();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el Lugar del departamento:");
		ret.Lugardep = teclado.nextLine().charAt(0);
		ret.setLugardep(ret.Lugardep);
		return ret;

	}

	public Departamento() {
		this.Lugardep = Lugardep;
	}

	public Departamento(char Lugardep) {
		this.Lugardep = Lugardep;
	}

	public char getLugardep() {
		return Lugardep;
	}

	public void setLugardep(char lugardep) {
		Lugardep = lugardep;
	}

	public String toString() {
		return "Departamento [lotes=" + ", Operarios=" + ", Lugardep=" + Lugardep + "]";
	}

}
