package entidades;

import java.util.Arrays;

import java.util.Scanner;

//import utils.Datos;
import validacion.DNIException;
import validacion.validador;

public class Operario {
	// Variable auxiliar para asignar el id automaticamente
	protected static int numOperario = 0;
	protected long idOperario;
	protected String NIF;
	protected String nombre;
	protected String apellido;
	protected long numTelefono;
	private String direccion;
	public boolean senior;
	protected Departamento[] lugardep;

//constructor por defecto del operario
	public Operario() {
		numOperario = numOperario + 1;
		this.idOperario = numOperario;

	}

	private static void validarDNI(String string) throws DNIException {
		// TODO Auto-generated method stub

	}

	public static void validaDNI(String NIF) {
		try {
			validarDNI("08941001G");
			// Si veo este mensaje es que no ha saltado ninguna excepcion
			System.out.println("El DNI esta bien");
		} catch (DNIException ex) {
			// Muestro el error concretamente
			System.out.println(ex.getMessage());
		}
	}

	public static Operario nuevoOperario() {
		Operario ret = null;
		Scanner teclado = new Scanner(System.in);
		long id = -1;
		Departamento lugarDep = null;
		boolean validaid = false;
		do {
			System.out.println("introduce el id >0");
			id = teclado.nextInt();
			validaid = validador.validarId(id);
		} while (!validaid);

		String nombre = "";
		boolean validanombre = false;
		do {
			System.out.println("introduce el nombre del cliente (mayor que 3 letras y menor que 15)");
			nombre = teclado.nextLine();
			validanombre = validador.validarnombre(nombre);

		} while (!validanombre);

		String apellido = "";
		boolean validaapellido = false;
		do {
			System.out.println("introduce el apellido, tiene que contener espacio entre los 2 apellidos");
			apellido = teclado.nextLine();
			validaapellido = validador.validarapellido(apellido);
		} while (!validaapellido);

		long numTelefono = -1;
		boolean validatlf = false;
		do {
			System.out.println("introduce un numero de telefono mayor de 900000000");
			numTelefono = teclado.nextLong();
			validatlf = validador.validanumtf(numTelefono);
		} while (!validatlf);

		String direccion = "";
		boolean validadireccion = false;
		do {
			System.out.println("introduce la direccion >5 y <10 palabras");
			direccion = teclado.nextLine();
			validadireccion = validador.validardireccion(direccion);
		} while (!validadireccion);

		System.out.println("Introduce el departamento en  el que trabaja el operario");
		lugarDep = Departamento.nuevoDepartamento();

		return ret;
	}

//	public static void mostraroperario() {
//		for (int i = 0; i < Datos.numOperarios; i++) {
//			Operario o = Datos.OPERARIOS[i];
//			System.out.println(o.toString());
//		}
//	}

	public Operario(long idOperario, String NIF, String nombre, String apellido, long num_telefono, String direccion,
			Departamento Lugardep) {
		this.idOperario = idOperario;
		this.NIF = NIF;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numTelefono = num_telefono;
		this.direccion = direccion;
	}

//constructor por atributos del operario
	public Operario(long idOperario, String NIF, String nombreApellido, long num_telefono, String direccion,
			boolean senior, char departamento) {
		numOperario = numOperario + 1;
		this.idOperario = numOperario;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el NIF:");
		NIF = teclado.nextLine();
		setNIF(NIF);

		Scanner teclado1 = new Scanner(System.in);
		System.out.println("Introduce el nombreApellido:");
		nombreApellido = teclado1.nextLine();
		setNIF(nombreApellido);

		Scanner teclado2 = new Scanner(System.in);
		System.out.println("Introduce el num_telefono:");
		num_telefono = teclado2.nextLong();
		setNumTelefono(numTelefono);

		Scanner teclado3 = new Scanner(System.in);
		System.out.println("Introduce la direccion:");
		direccion = teclado3.nextLine();
		setDireccion(direccion);

		Scanner teclado4 = new Scanner(System.in);
		System.out.println("Introduce el NIF:");
		senior = teclado4.nextBoolean();
		setSenior(senior);

	}

	public static int getNumOperario() {
		return numOperario;
	}

	public static void setNumOperario(int numOperario) {
		Operario.numOperario = numOperario;
	}

	public long getIdOperario() {
		return idOperario;
	}

	public void setIdOperario(long idOperario) {
		this.idOperario = idOperario;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
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
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isSenior() {
		return senior;
	}

	public void setSenior(boolean senior) {
		this.senior = senior;
	}

	public long getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(long numTelefono) {
		this.numTelefono = numTelefono;
	}

	public Departamento[] getLugardep() {
		return lugardep;
	}

	public void setLugardep(Departamento[] lugardep) {
		this.lugardep = lugardep;
	}

	@Override
	public String toString() {
		return "Operario [idOperario=" + idOperario + ", NIF=" + NIF + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", numTelefono=" + numTelefono + ", direccion=" + direccion + ", senior=" + senior + ", lugardep="
				+ Arrays.toString(lugardep) + "]";
	}

}
