package entidades;

import java.util.Scanner;

public class Departamento {
	private char idDep;

// Constructor por defecto de la clase departamento	
	public Departamento() {
		
	}

// Constructor con atributos dela clase departameto	
	public Departamento(char idDep) {
		this.idDep = idDep;
	}
	
// Metodo para generar un nuevo departamento	
	public static Departamento nuevoDepartamento() {
		Departamento ret = new Departamento();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el Lugar del departamento:");
		ret.idDep = teclado.nextLine().charAt(0);
		ret.setidDep(ret.idDep);
		return ret;

	}

// Getters y Setters del atributo de la clase departamento
	public char getidDep() {
		return idDep;
	}

	public void setidDep(char idDep) {
		idDep = idDep;
	}

// Metodo toString()	
	public String toString() {
		return idDep + "|";
	}

}
