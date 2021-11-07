package entidades;

import java.util.Arrays;
import java.util.Scanner;

public class Operario {
	// Variable auxiliar para asignar el id automaticamente
	protected static int numOperario = 0;
	protected long idOperario;
	protected String NIF;
	protected String nombreApellido;
	protected long num_telefono;
	private String direccion;
	public boolean senior;
	protected Departamento[] departamentos;

//constructor por defecto del operario
	public Operario() {
		numOperario = numOperario + 1;
		this.idOperario = numOperario;

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
		setNum_telefono(num_telefono);

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

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public long getNum_telefono() {
		return num_telefono;
	}

	public void setNum_telefono(long num_telefono) {
		this.num_telefono = num_telefono;
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

	public Departamento[] getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamento[] departamentos) {
		this.departamentos = departamentos;
	}

	@Override
	public String toString() {
		return "Operario [idOperario=" + idOperario + ", NIF=" + NIF + ", nombreApellido=" + nombreApellido
				+ ", num_telefono=" + num_telefono + ", direccion=" + direccion + ", senior=" + senior
				+ ", departamentos=" + Arrays.toString(departamentos) + "]";
	}
}
