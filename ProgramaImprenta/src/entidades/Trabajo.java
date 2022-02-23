package entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
	
	//Método que crea y exporta un único objeto de tipo trabajo a un fichero de texto 
			public static void exportarTrabajoTXT(Trabajo Trabajo) {
				String path = "trabajo.txt";
				File fichero = new File(path);
				FileWriter escritor = null;
				PrintWriter buffer = null;
				try {
					try {
						escritor = new FileWriter(fichero, false);
						buffer = new PrintWriter(escritor);
						buffer.println(Trabajo.nuevoTrabajo().trabajosData());

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

		//Método que exporta todos los trabajos de la coleccion Datos.TRABAJOS a un fichero de texto
			public static void exportarTrabajosTXT(Trabajo[] trabajo) {
				String path = "trabajos.txt";
				File fichero = new File(path);
				FileWriter escritor = null;
				PrintWriter buffer = null;
				try {
					try {
						escritor = new FileWriter(fichero, false);
						buffer = new PrintWriter(escritor);
						for (Trabajo t : Datos.TRABAJOS) {
							buffer.println(t.trabajosData());
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

		//Método que crea y exporta un único objeto de tipo trabajo a un fichero de texto 
			public static void exportarTrabajoBinario(Trabajo trabajo) {
				String path = "trabajo.dat";
				try {
					FileOutputStream fichero = new FileOutputStream(path, false);
					ObjectOutputStream escritor = new ObjectOutputStream(fichero);
					escritor.writeObject(Trabajo.nuevoTrabajo().trabajosData());
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

		//Método que exporta todos los trabajos de la coleccion Datos.MAQUINAS a un fichero binario
			public static void exportarTrabajosBinario(Trabajo[] trabajo) {
				String path = "trabajos.dat";
				try {
					FileOutputStream fichero = new FileOutputStream(path, false);
					ObjectOutputStream escritor = new ObjectOutputStream(fichero);
					for (Trabajo t : Datos.TRABAJOS) {
						escritor.writeObject(t.trabajosData());
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

//	public static void mostrarTrabajo() {
//		System.out.println("Lista de trabajos disponibles");
//		for (int i = 0; i < Datos.numTrabajos; i++) {
//			Trabajo t = Datos.TRABAJOS[i];
//			System.out.println(t);
//		}
//	}

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