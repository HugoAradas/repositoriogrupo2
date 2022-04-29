package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;

import java.util.Scanner;

import utils.Datos;
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
	protected Departamento idDep;

//constructor por defecto del operario
	public Operario() {
		numOperario = numOperario + 1;
		this.idOperario = numOperario;

	}

	public static void verOperarios() {
		Operario[] operario = Datos.OPERARIOS;
		for (int i = 0; i < operario.length; i++)
			if (operario[i] != null)
				System.out.println(operario[i].operariosData());
	}

//Método data de operario, devuelve un string con todos los datos del operario separados mediante " | "
	public String operariosData() {
		String ret = "";
		ret = "id: " + this.idOperario + " | " + " Nombre y apellidos: " + this.nombre + " " + this.apellido + " | "
				+ " con NIF: " + this.NIF + " | " + " Número de teléfono: " + this.numTelefono + " | " + " Direccion: "
				+ this.direccion + " | " + " Senior: " + this.senior + " | " + " Del departamento: " + this.idDep;
		return ret;

	}

//Método que crea y exporta un único objeto de tipo operario a un fichero de texto 
	public void exportarOperarioTXT() {
		String path = "operario.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				buffer.println(this.operariosData());

			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (escritor != null) {
					escritor.close();
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Se ha producido una FileNotFoundException" + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Se ha producido una IOException" + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Se ha producido una Exception" + ex.getMessage());
		}
	}

//Método que exporta todos los operarios de la coleccion Datos.OPERARIOS a un fichero de texto
	public static void exportarOperariosTXT() {
		String path = "operarios.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				for (Operario o : Datos.OPERARIOS) {
					buffer.println(o.operariosData());
				}

			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (escritor != null) {
					escritor.close();
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Se ha producido una FileNotFoundException" + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Se ha producido una IOException" + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Se ha producido una Exception" + ex.getMessage());
		}
	}

//Método que crea y exporta un único objeto de tipo operario a un fichero de texto 
	public void exportarOperarioBinario() {
		String path = "operario.dat";
		try {
			File fichero = new File(path);
			FileOutputStream fos = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(fos);
			escritor.writeObject(this.operariosData());
			escritor.flush();
			escritor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}

//Método que exporta todos los operarios de la coleccion Datos.OPERARIOS a un fichero binario
	public static void exportarOperariosBinario() {
		String path = "operarios.dat";
		try {
			File fichero = new File(path);
			FileOutputStream fos = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(fos);
			for (Operario o : Datos.OPERARIOS) {
				escritor.writeObject(o.operariosData());
				escritor.flush();
			}
			escritor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}

//Método que impoprta una coleccíon de objetos de tipo operario desde un fichero de texto
	public static void importarOperariosTXT() {
		File fIn = new File("OperarioChar.txt");
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(fIn);
			br = new BufferedReader(fr);
			String s;

			for (int i = 0; i < 6; i++) {
				s = (String) br.readLine();
				System.out.println(s);
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//Método que impoprta una coleccíon de objetos de tipo operario desde un fichero binario
	public static void importarOperariosBinario() {
		System.out.println("Cargando datos de operarioByte.dat...");
		File ci;
		FileInputStream fis = null;
		ObjectInputStream lector = null;
		try {
			ci = new File("operarioByte.dat");
			fis = new FileInputStream(ci);
			lector = new ObjectInputStream(fis);

			for (int i = 0; i < 6; i++) { // puedo usar Datos.numOperarios para el limite pero no contaria el
											// nuevo operario.
				Operario o = (Operario) lector.readObject();
				System.out.println(o.operariosData());
			}
//		Cliente c = (Cliente) ois.readObject();
//		System.out.println(c.data());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (lector != null)
					lector.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void elegirImportarOperario() {
		Scanner teclado = new Scanner(System.in);
		boolean eleccionValida = false;
		char eleccion;
		do {
			System.out
					.println("¿Desde dónde desea importar los operarios, fichero de texto (T) o fichero binario (B)?");
			eleccion = teclado.next().charAt(0);
			if (eleccion == 'T' || eleccion == 't' || eleccion == 'B' || eleccion == 'b') {
				eleccionValida = true;
			} else {
				eleccionValida = false;
			}
		} while (!eleccionValida);
		if (eleccion == 't' || eleccion == 'T') {
			Operario.importarOperariosTXT();
		}

		if (eleccion == 'b' || eleccion == 'B') {
			Operario.importarOperariosBinario();
		}
	}

	public static void elegirExportarOperario() {
		Scanner teclado = new Scanner(System.in);
		boolean eleccionValida = false;
		char eleccion;
		do {
			System.out.println("¿A dónde desea exportar los operarios, fichero de texto (T) o fichero binario (B)?");
			eleccion = teclado.next().charAt(0);
			if (eleccion == 'T' || eleccion == 't' || eleccion == 'B' || eleccion == 'b') {
				eleccionValida = true;
			} else {
				eleccionValida = false;
			}
		} while (!eleccionValida);
		if (eleccion == 't' || eleccion == 'T') {
			Operario.exportarOperariosTXT();
		}

		if (eleccion == 'b' || eleccion == 'B') {
			Operario.exportarOperariosBinario();
		}
	}

	public static void buscarOperario() {
		Scanner teclado = new Scanner(System.in);
		boolean seleccionValida = false;
		long buscaid;

		do {
			System.out.println("Introduce el id del operario que desea buscar (el id debe ser mayor que 0)");
			buscaid = teclado.nextLong();
			if (buscaid > 0) {
				seleccionValida = true;
			} else {
				seleccionValida = false;
			}
		} while (!seleccionValida);
		for (Operario o : Datos.OPERARIOS) {
			if (o.getIdOperario() == buscaid) {
				System.out.println(o.operariosData());
			}
		}
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
		Departamento idDep = null;
		boolean validaid = false;
		do {
			System.out.println("introduce el id >0");
			id = teclado.nextInt();
			validaid = validador.validarId(id);
		} while (!validaid);

		String nombre = "";
		boolean validanombre = false;
		do {
			System.out.println("introduce el nombre del operario (mayor que 3 letras y menor que 15)");
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
		idDep = Departamento.nuevoDepartamento();

		return ret;
	}

//	public static void mostraroperario() {
//		for (int i = 0; i < Datos.numOperarios; i++) {
//			Operario o = Datos.OPERARIOS[i];
//			System.out.println(o.toString());
//		}
//	}

	public Operario(long idOperario, String NIF, String nombre, String apellido, long num_telefono, String direccion,
			boolean senior, Departamento idDep) {
		this.idOperario = idOperario;
		this.NIF = NIF;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numTelefono = num_telefono;
		this.direccion = direccion;
		this.senior = senior;
	}

//constructor por atributos del operario
	public Operario(long idOperario, String NIF, String nombre, String apellido, long num_telefono, String direccion,
			boolean senior, char idDep) {
		numOperario = numOperario + 1;
		this.idOperario = numOperario;
		this.NIF = NIF;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numTelefono = num_telefono;
		this.direccion = direccion;
		this.senior = senior;
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

	public Departamento getidDep() {
		return idDep;
	}

	public void setidDep(Departamento idDep) {
		this.idDep = idDep;
	}

	@Override
	public String toString() {
		return idOperario + "|" + NIF + "|" + nombre + "|" + apellido + "|" + numTelefono + "|" + direccion + "|"
				+ senior + "|" + idDep;
	}

}
