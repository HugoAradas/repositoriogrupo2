package entidades;

import java.util.Scanner;

import validacion.validador;

public class Cliente {
	// Variable auxiliar para asignar el id automaticamente
	public static int numClientes = 0;
	public long idCliente;
	private String nombre;
	private String apellido;

// Constructor por defecto de la clase cliente
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
// Constructor con atributos de la clase cliente
	public Cliente(long idCliente, String nombre, String apellido) {
		numClientes = numClientes + 1;
		this.idCliente = numClientes;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el NombreApellido:");
		nombre = teclado.nextLine();
		setNombre(nombre);
		System.out.println("introduce el apellido");
		apellido = teclado.nextLine();
		setApellido(apellido);
		
	}
	
// Metodo para generar un nuevo cliente
	public static Cliente nuevoCliente() {
		Cliente ret = null;
		Scanner teclado = new Scanner(System.in);
		System.out.println("introduce un id valido para el cliente");
		long id = -1;
		boolean validaid = false;
		do {
			System.out.println("El id del cliente tiene que ser siempre mayor que cero");
			id = teclado.nextLong();
			validaid = validador.validarId(id);
		} while (!validaid);

		String nombre = "";
		boolean nombrevalido = false;
		do {
			System.out.println("introduce   nombre del cliente (mayor que 3 letras y menor que 15)");
			nombre = teclado.nextLine();
			nombrevalido = validador.validarnombre(nombre);
		} while (!nombrevalido);

		String apellido = "";
		boolean apellidovalido = false;
		do {
			System.out.println("introduce el apellido, tiene que contener espacio entre los 2 apellidos");
			apellido = teclado.nextLine();
			apellidovalido = validador.validarapellido(apellido);
		} while (!apellidovalido);

		ret = new Cliente(id, nombre, apellido);
		return ret;

	}
	
// Getters y Setters de los atributos de la clase
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

// Metodo toString()	
	public String toString() {
		return idCliente + "|" + nombre + "|" + apellido;
	}

}
