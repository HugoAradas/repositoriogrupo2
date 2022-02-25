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
import utils.Utilidades;
//import utils.Datos;
import validacion.validador;

public class Trabajo {
	// Variable auxiliar para asignar el id automaticamente
	public static int numTrabajos = 0;
	// valor mínimo 1
	protected long idTrabajo;
	protected LocalDate fechaSolicitud;
	protected LocalDate fechaEntrega;
	// mínimo 3 caracteres, máximo 25
	protected String tipoRelieve;
	protected Cliente[] idCliente;
	protected Maquina[] idMaquina;

	public Cliente[] getCliente() {
		return idCliente;
	}

	public void setClientes(Cliente[] idCliente) {
		this.idCliente = idCliente;
	}

	// Constructor por defecto de la clase Trabajo
	public Trabajo() {
		numTrabajos = numTrabajos + 1;
		this.idTrabajo = numTrabajos;
	}

	public static void verTrabajos() {
		Trabajo[] trabajos = Datos.TRABAJOS;
		for (int i = 0; i < trabajos.length; i++)
			if (trabajos[i] != null)
				System.out.println(trabajos[i].trabajosData());
	}

	// Método data de Trabajo, devuelve un string con todos los datos del trabajo
	// separados mediante " | "
	public String trabajosData() {
		String ret = "";
		ret = "id: " + this.idTrabajo + " | " + " Fecha de solicitud: " + this.fechaSolicitud + " | "
				+ " Fecha de entrega: " + this.fechaEntrega + " | " + " Tipo de relieve: " + this.tipoRelieve + " | "
				+ " Id del cliente: " + this.idCliente + " | " + " Hecho por la máquina con id: " + this.idMaquina;
		return ret;
	}

	// Método que crea y exporta un único objeto de tipo Trabajo a un fichero de
	// texto
	public void exportarTrabajoTXT() {
		String path = "trabajo.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				buffer.println(this.trabajosData());

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

	// Método que exporta todos los Trabajos de la coleccion Datos.TRABAJOS a un
	// fichero de texto
	public static void exportarTrabajosTXT() {
		String path = "trabajos.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				for (Trabajo o : Datos.TRABAJOS) {
					buffer.println(o.trabajosData());
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

	// Método que crea y exporta un único objeto de tipo Trabajo a un fichero de
	// texto
	public void exportarTrabajoBinario() {
		String path = "trabajo.dat";
		try {
			File fichero = new File(path);
			FileOutputStream fos = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(fos);
			escritor.writeObject(this.trabajosData());
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

	// Método que exporta todos los Trabajos de la coleccion Datos.TRABAJOS a un
	// fichero binario
	public static void exportarTrabajosBinario() {
		String path = "Trabajos.dat";
		try {
			File fichero = new File(path);
			FileOutputStream fos = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(fos);
			for (Trabajo o : Datos.TRABAJOS) {
				escritor.writeObject(o.trabajosData());
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

	// Método que impoprta una coleccíon de objetos de tipo Trabajo desde un fichero
	// de texto
	public static void importarTrabajosTXT() {
		File fIn = new File("TrabajoChar.txt");
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

	// Método que impoprta una coleccíon de objetos de tipo Trabajo desde un fichero
	// binario
	public static void importarTrabajosBinario() {
		System.out.println("Cargando datos de trabajoByte.dat...");
		File ci;
		FileInputStream fis = null;
		ObjectInputStream lector = null;
		try {
			ci = new File("trabajoByte.dat");
			fis = new FileInputStream(ci);
			lector = new ObjectInputStream(fis);

			for (int i = 0; i < 6; i++) { // puedo usar Datos.numTrabajos para el limite pero no contaria el
											// nuevo trabajo.
				Trabajo o = (Trabajo) lector.readObject();
				System.out.println(o.trabajosData());
			}
//			Cliente c = (Cliente) ois.readObject();
//			System.out.println(c.data());

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

	public static void elegirImportarTrabajo() {
		Scanner teclado = new Scanner(System.in);
		boolean eleccionValida = false;
		char eleccion;
		do {
			System.out.println("¿Desde dónde desea importar los trabajos, fichero de texto (T) o fichero binario (B)?");
			eleccion = teclado.next().charAt(0);
			if (eleccion == 'T' || eleccion == 't' || eleccion == 'B' || eleccion == 'b') {
				eleccionValida = true;
			} else {
				eleccionValida = false;
			}
		} while (!eleccionValida);
		if (eleccion == 't' || eleccion == 'T') {
			Trabajo.importarTrabajosTXT();
		}

		if (eleccion == 'b' || eleccion == 'B') {
			Trabajo.importarTrabajosBinario();
		}
	}

	public static void buscarTrabajo() {
		Scanner teclado = new Scanner(System.in);
		boolean seleccionValida = false;
		long buscaid;

		do {
			System.out.println("Introduce el id del trabajo que desea buscar (el id debe ser mayor que 0)");
			buscaid = teclado.nextLong();
			if (buscaid > 0) {
				seleccionValida = true;
			} else {
				seleccionValida = false;
			}
		} while (!seleccionValida);
		for (Trabajo t : Datos.TRABAJOS) {
			if (t.getIdTrabajo() == buscaid) {
				System.out.println(t.trabajosData());
			}
		}
	}

	public static Trabajo nuevoTrabajo() {
		Trabajo ret = new Trabajo();
		Scanner teclado = new Scanner(System.in);
		long idTrabajo = -1;
		boolean validaid = false;
		do {
			System.out.println("El id del trabajo tiene que ser siempre mayor que cero");
			idTrabajo = teclado.nextLong();
			validaid = validador.validarId(idTrabajo);
		} while (!validaid);
		ret.setIdTrabajo(idTrabajo);
		String tipoRelieve = "";
		boolean validarelieve = false;
		do {
			System.out.println("Introduce el tipo de relieve");
			tipoRelieve = teclado.next();
			validarelieve = validador.validarTipoRelieve(tipoRelieve);
		} while (!validarelieve);
		ret.setTipoRelieve(tipoRelieve);

		System.out.println("Introduce la fecha de solicitud");
		ret.fechaSolicitud = Utilidades.leerFecha();

		System.out.println("Introduce la fecha de entrega");
		ret.fechaEntrega = Utilidades.leerFecha();

		return ret;

	}

//Constructor por atributos de Trabajo	
	public Trabajo(long idTrabajo, LocalDate fechaSolicitud, LocalDate fechaEntrega, String tipoRelieve,
			Cliente idCliente, Maquina idMaquina) {
		numTrabajos = numTrabajos + 1;
		this.idTrabajo = numTrabajos;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaEntrega = fechaEntrega;
		this.tipoRelieve = tipoRelieve;
	}

	public static int getNumTrabajos() {
		return numTrabajos;
	}

	public static void setNumTrabajos(int numTrabajos) {
		Trabajo.numTrabajos = numTrabajos;

	}

	public long getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(long idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getTipoRelieve() {
		return tipoRelieve;
	}

	public void setTipoRelieve(String tipoRelieve) {
		this.tipoRelieve = tipoRelieve;
	}

	@Override
	public String toString() {
		return idTrabajo + "|" + fechaSolicitud + "|" + fechaEntrega + "|" + tipoRelieve + "|" + idCliente + "|"
				+ idMaquina;
	}

}