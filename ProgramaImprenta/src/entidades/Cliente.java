package entidades;

import java.util.Arrays;
import java.util.Scanner;

public class Cliente {
	// Variable auxiliar para asignar el id automaticamente
	public static int numClientes = 0;
	public long idCliente;
	private String nombreApellido;
	// Array de trabajos, debido a la relacion varios a varios entre cliente y
	// trabajo
	private Trabajo[] trabajos;

//Constructor por defecto de la clase cliente
	public static Cliente nuevoCliente() {
		numClientes = numClientes + 1;
		Cliente ret = new Cliente();
		ret.idCliente = numClientes;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el NombreApellido:");
		ret.nombreApellido = teclado.nextLine();
		ret.setNombreApellido(ret.nombreApellido);
		return ret;
		
	}

//Constructor con atributos de la calse cliente
	public Cliente(long idCliente, String nombreApellidos) {
		numClientes = numClientes + 1;
		this.idCliente = numClientes;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el NombreApellido:");
		nombreApellido = teclado.nextLine();
		setNombreApellido(nombreApellido);

	}

	public Cliente() {
	// TODO Auto-generated constructor stub
}

	public static int getNumClientes() {
		return numClientes;
	}

	public static void setNumClientes(int numClientes) {
		Cliente.numClientes = numClientes;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public Trabajo[] getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(Trabajo[] trabajos) {
		this.trabajos = trabajos;
	}

	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreApellido=" + nombreApellido + ", trabajos="
				+ Arrays.toString(trabajos) + "]";
	}

}
