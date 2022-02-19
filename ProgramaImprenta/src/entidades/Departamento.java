package entidades;

import java.util.Arrays;
import java.util.Scanner;

public class Departamento {
	private char idDep;

	public static Departamento nuevoDepartamento() {
		Departamento ret = new Departamento();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el Lugar del departamento:");
		ret.idDep = teclado.nextLine().charAt(0);
		ret.setidDep(ret.idDep);
		return ret;

	}

	public Departamento() {
		this.idDep = idDep;
	}

	public Departamento(char idDep) {
		this.idDep = idDep;
	}

	public char getidDep() {
		return idDep;
	}

	public void setidDep(char idDep) {
		idDep = idDep;
	}

	public String toString() {
		return idDep + "|";
	}

}
