package entidades;

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
		for (Maquina m : Datos.MAQUINAS) {
			System.out.println(m.maquinasData());
		}
	}

	// Método data de máquina, devuelve un string con todos los datos de la máquina
	// separados mediante " | "
	public String maquinasData() {
		String ret = "";
		ret = "id: " + this.idMaquina + " | " + " Fecha de compra: " + this.fechaCompra + " | " + " Ubicacion: "
				+ this.ubicacion + " | " + " Tipo de impresion: " + this.tipoImpresion + " | " + " Modo de impresion: "
				+ this.modoImpresion + " | " + " Volumen de tinta: " + this.volumenTinta;
		return ret;
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

//	public static void mostrarmaquina() {
//		for (int i = 0; i < Datos.numMaquina; i++) {
//			Maquina m = Datos.MAQUINAS[i];
//			System.out.println(m.toString());
//		}
//	}

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
