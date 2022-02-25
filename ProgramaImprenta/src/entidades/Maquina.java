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

public class Maquina {
	// Variable auxiliar para asignar el id automaticamente
	public static int numMaquinas = 0;
	private long idMaquina;
	private LocalDate fechaCompra;
	private String ubicacion;
	private String tipoImpresion;
	private String modoImpresion;
	private double volumenTinta;
	// Identificadro del lote, debido a la relacion entre maquina y lote
	private Lote idLote;

//Constructor por defecto de Maquina
	public Maquina() {
		numMaquinas = numMaquinas + 1;
		this.idMaquina = numMaquinas;

	}

	public static void verMaquinas() {
		Maquina[] maquina = Datos.MAQUINAS;
		for (int i = 0; i < maquina.length; i++)
			if (maquina[i] != null)
				System.out.println(maquina[i].maquinasData());
	}

	// Método data de máquina, devuelve un string con todos los datos de la
	// máquina
	// separados mediante " | "
	public String maquinasData() {
		String ret = "";
		ret = "id: " + this.idMaquina + " | " + " Fecha de compra: " + this.fechaCompra + " | " + " Ubicacion: "
				+ this.ubicacion + " | " + " Tipo de impresion: " + this.tipoImpresion + " | " + " Modo de impresion: "
				+ this.modoImpresion + " | " + " Volumen de tinta: " + this.volumenTinta;
		return ret;
	}

	public static void buscarMaquina() {
		Scanner teclado = new Scanner(System.in);
		boolean seleccionValida = false;
		long buscaid;

		do {
			System.out.println("Introduce el id de la máquina que desea buscar (el id debe ser mayor que 0)");
			buscaid = teclado.nextLong();
			if (buscaid > 0) {
				seleccionValida = true;
			} else {
				seleccionValida = false;
			}
		} while (!seleccionValida);
		for (Maquina m : Datos.MAQUINAS) {
			if (m.getId_maquina() == buscaid) {
				System.out.println(m.maquinasData());
			}
		}
	}

	public static Maquina nuevaMaquina() {
		Maquina ret = null;
		Scanner teclado = new Scanner(System.in);
		long id = -1;
		LocalDate fechaCompra = null;
		Lote idLote = null;
		boolean validaidMaquina = false;

		do {
			System.out.println("introduce un id de maquina (>0)");
			id = teclado.nextLong();
			validaidMaquina = validador.validarmaquina(id);
		} while (!validaidMaquina);

		System.out.println("Introduce la fecha de la compra");
		fechaCompra = Utilidades.leerFecha();

		String ubicacion = "";
		boolean validarUbi = false;
		do {
			System.out.println("introduce una ubi (> 10 y <20 palabras)");
			ubicacion = teclado.nextLine();
			validarUbi = validador.validaubicacion(ubicacion);
		} while (!validarUbi);

		String tipoImpresion = "";
		boolean validaImpresion = false;
		do {
			System.out.println("introduce el tipo de impresion (>5 y <10 palabras)");
			tipoImpresion = teclado.nextLine();
			validaImpresion = validador.validamodoimpresion(tipoImpresion);
		} while (!validaImpresion);

		String modoImpresion = "";
		boolean validamodoImpresion = false;
		do {
			System.out.println("introduce el modo de impresion que se llevo a cabo (>5 y <10 palabras)");
			modoImpresion = teclado.nextLine();
			validamodoImpresion = validador.validamodoimpresion(modoImpresion);
		} while (!validamodoImpresion);

		double volumenTinta = -1.0;
		boolean validavolumen = false;
		do {
			System.out.println("introduce un volumen de tinta >0.0");
			volumenTinta = teclado.nextDouble();
			validavolumen = validador.validavolumentinta(volumenTinta);
		} while (!validavolumen);

		System.out.println("introduce el lote donde esta la m�quina");
		idLote = Lote.nuevoLote();
		ret = new Maquina(id, fechaCompra, ubicacion, tipoImpresion, modoImpresion, volumenTinta, idLote);
		return ret;
	}

	// Metodo para importar a texto
	public void exportarMaquinaTXT() {
		String path = "maquina.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				buffer.println(this.maquinasData());

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
	// Metodo para exportar todas las maquinas de la clase maquina

	public static void exportarMaquinasTXT() {
		String path = "maquinas.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				for (Maquina m : Datos.MAQUINAS) {
					buffer.println(m.maquinasData());
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

	// metodo para exportar binario
	public void exportarMaquinaBinario() {
		String path = "maquina.dat";
		try {
			File fichero = new File(path);
			FileOutputStream fos = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(fos);
			escritor.writeObject(this.maquinasData());
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

	// metodo para exportar coleccion a binario
	public static void exportarMaquinasBinario() {
		String path = "maquina.dat";
		try {
			File fichero = new File(path);
			FileOutputStream fos = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(fos);
			for (Maquina m : Datos.MAQUINAS) {
				escritor.writeObject(m.maquinasData());
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

	// metodo para importar una coleccion a un texto
	public static void importarMaquina() {
		File fIn = new File("maquina.txt");
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

	// metodo para importar una la coleccion de maquinas desde un binario
	public static void importarMaquinaBinario() {
		System.out.println("Cargando datos de maquinaByte.dat...");
		File ci;
		FileInputStream fis = null;
		ObjectInputStream lector = null;
		try {
			ci = new File("maquinaByte.dat");
			fis = new FileInputStream(ci);
			lector = new ObjectInputStream(fis);

			for (int i = 0; i < 6; i++) {
				Maquina m = (Maquina) lector.readObject();
				System.out.println(m.maquinasData());
			}
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

	public static void elegirImportarMaquina() {
		Scanner teclado = new Scanner(System.in);
		boolean eleccionValida = false;
		char eleccion;
		do {
			System.out
					.println("¿Desde donde quiere importar las maquinas, fichero de texto (T) o fichero binario (B)?");
			eleccion = teclado.next().charAt(0);
			if (eleccion == 'T' || eleccion == 't' || eleccion == 'B' || eleccion == 'b') {
				eleccionValida = true;
			} else {
				eleccionValida = false;
			}
		} while (!eleccionValida);
		if (eleccion == 't' || eleccion == 'T') {
			Maquina.importarMaquina();
		}

		if (eleccion == 'b' || eleccion == 'B') {
			Maquina.importarMaquinaBinario();
		}
	}

	public static void elegirExportarMaquina() {
		Scanner teclado = new Scanner(System.in);
		boolean eleccionValida = false;
		char eleccion;
		do {
			System.out.println("¿A dónde desea exportar las máquinas, fichero de texto (T) o fichero binario (B)?");
			eleccion = teclado.next().charAt(0);
			if (eleccion == 'T' || eleccion == 't' || eleccion == 'B' || eleccion == 'b') {
				eleccionValida = true;
			} else {
				eleccionValida = false;
			}
		} while (!eleccionValida);
		if (eleccion == 't' || eleccion == 'T') {
			Maquina.exportarMaquinasTXT();
		}

		if (eleccion == 'b' || eleccion == 'B') {
			Maquina.exportarMaquinasBinario();
		}
	}

	public Maquina(long id, LocalDate fechaCompra, String ubicacion, String tipoImpresion, String modoImpresion,
			double volumenTinta, Lote idLote) {
		this.idMaquina = id;
		this.fechaCompra = fechaCompra;
		this.ubicacion = ubicacion;
		this.tipoImpresion = tipoImpresion;
		this.modoImpresion = modoImpresion;
		this.volumenTinta = volumenTinta;
		this.idLote = idLote;
	}

//Constructor por atributos de Maquina
	public Maquina(long idMaquina, int fecha_compra, String ubicacion, Lote idLote) {
		numMaquinas = numMaquinas + 1;
		this.idMaquina = numMaquinas;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la ubicacion:");
		ubicacion = teclado.nextLine();
		setUbicacion(ubicacion);
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public long getId_maquina() {
		return idMaquina;
	}

	public void setId_maquina(long idMaquina) {
		this.idMaquina = idMaquina;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public static int getNumMaquinas() {
		return numMaquinas;
	}

	public static void setNumMaquinas(int numMaquinas) {
		Maquina.numMaquinas = numMaquinas;
	}

	public long getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(long idMaquina) {
		this.idMaquina = idMaquina;
	}

	public String getTipoImpresion() {
		return tipoImpresion;
	}

	public void setTipoImpresion(String tipoImpresion) {
		this.tipoImpresion = tipoImpresion;
	}

	public String getModoImpresion() {
		return modoImpresion;
	}

	public void setModoImpresion(String modoImpresion) {
		this.modoImpresion = modoImpresion;
	}

	public double getVolumenTinta() {
		return volumenTinta;
	}

	public void setVolumenTinta(double volumenTinta) {
		this.volumenTinta = volumenTinta;
	}

	public Lote getIdLote() {
		return idLote;
	}

	public void setIdLote(Lote idLote) {
		this.idLote = idLote;
	}

	@Override
	public String toString() {
		return idMaquina + "|" + fechaCompra + "|" + ubicacion + "|" + tipoImpresion + "|" + modoImpresion + "|"
				+ volumenTinta + "|" + idLote;
	}

}
