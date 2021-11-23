package entidades;

import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Cliente {
	// Variable auxiliar para asignar el id automaticamente
	public static int numClientes = 0;
	public long idCliente;
	private String nombre;
	private String apellido;

	// Array de trabajos, debido a la relacion varios a varios entre cliente y
	// trabajo
	private Trabajo[] trabajos;

//Constructor por defecto de la clase cliente
	public static Cliente nuevoCliente() {
		Cliente ret = new Cliente();
		Scanner teclado = new Scanner(System.in);
		System.out.println("introduce un id valido para el cliente");
		long id = -1;
		boolean nifvalido = false;
		do {
			System.out.println("El id del cliente tiene que ser siempre mayor que cero");
			id = teclado.nextLong();
			nifvalido = validador.validarId(id);
		} while (!nifvalido);
		ret.setIdCliente(id);

		String nombre = "";
		boolean nombrevalido = false;
		do {
			System.out.println("introduce el nombre del cliente (mayor que 3 letras y menor que 15");
			nombre = teclado.nextLine();
			nombrevalido = validador.validarnombre(nombre);
		} while (!nombrevalido);
		ret.setNombre(nombre);
		
		String apellido ="";
		boolean apellidovalido = false; 
		do {
			System.out.println("introduce el apellido, tiene que contener espacio entre los 2 apellidos");
			apellido= teclado.nextLine();
			apellidovalido = validador.validarapellido(apellido);
		} while (!apellidovalido);
		ret.setApellido(apellido);
		
		return ret;

	}

//Constructor con atributos de la calse cliente
	public Cliente(long idCliente, String nombre, String apellido) {
		numClientes = numClientes + 1;
		this.idCliente = numClientes;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el NombreApellido:");
		nombre = teclado.nextLine();
		setNombre(nombre);
		System.out.println ("introduce el apellido");
		apellido = teclado.nextLine();
		setApellido (apellido);

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		apellido = apellido;
	}

	public Trabajo[] getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(Trabajo[] trabajos) {
		this.trabajos = trabajos;
	}

	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreApellido=" + nombre + ", trabajos="
				+ Arrays.toString(trabajos) + "]";
	}

}
