package entidades;

import java.time.LocalDate;
import java.util.Scanner;

import validacion.validador;

public class Maquina {
	// Variable auxiliar para asignar el id automaticamente
	public static int numMaquinas = 0;
	protected long idMaquina;
	private int fecha_compra;
	private String ubicacion;
	public String tipoImpresion;
	public String modoImpresion;
	public double volumenTinta;
	// Identificadro del lote, debido a la relacion entre maquina y lote
	private long idLote;

//Constructor por defecto de Maquina
	public Maquina() {
		numMaquinas = numMaquinas + 1;
		this.idMaquina = numMaquinas;

	}

	public static Maquina nuevaMaquina() {
		Maquina ret = new Maquina();
		Scanner teclado = new Scanner(System.in);
		long id = -1;
		boolean validaidMaquina = false;
		do {
			System.out.println("introduce un id de maquina (>0)");
			id = teclado.nextLong();
			validaidMaquina = validador.validarmaquina(id);
		} while (!validaidMaquina);
		ret.setIdMaquina(id);

		String ubicacion = "";
		boolean validarUbi = false;
		do {
			System.out.println("introduce una ubi (> 10 y <20 palabras)");
			ubicacion = teclado.nextLine();
			validarUbi = validador.validaubicacion(ubicacion);
		} while (!validarUbi);
		ret.setUbicacion(ubicacion);

		String tipoImpresion = "";
		boolean validaImpresion = false;
		do {
			System.out.println("introduce el tipo de impresion (>5 y <10 palabras)");
			tipoImpresion = teclado.nextLine();
			validaImpresion = validador.validamodoimpresion(tipoImpresion);
		} while (!validaImpresion);
		ret.setTipoImpresion(tipoImpresion);

		String modoImpresion = "";
		boolean validamodoImpresion = false;
		do {
			System.out.println("introduce el modo de impresion que se llevo a cabo (>5 y <10 palabras)");
			modoImpresion = teclado.nextLine();
			validamodoImpresion = validador.validamodoimpresion(modoImpresion);
		} while (!validamodoImpresion);
		ret.setModoImpresion(modoImpresion);
		double volumenTinta = -1.0;
		boolean validavolumen = false;
		do {
			System.out.println("introduce un volumen de tinta >0.0");
			volumenTinta = teclado.nextDouble();
			validavolumen = validador.validavolumentinta(volumenTinta);
		}while (!validavolumen);
		ret.setVolumenTinta(volumenTinta);
		return ret;
	}

//Constructor por atributos de Maquina
	public Maquina(long idMaquina, int fecha_compra, String ubicacion) {
		numMaquinas = numMaquinas + 1;
		this.idMaquina = numMaquinas;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la ubicacion:");
		ubicacion = teclado.nextLine();
		setUbicacion(ubicacion);
	}

	public String toString() {
		return "Maquina [idMaquina=" + idMaquina + ", fecha_compra=" + fecha_compra + ", ubicacion=" + ubicacion
				+ ", tipoImpresion=" + tipoImpresion + ", modoImpresion=" + modoImpresion + ", volumenTinta="
				+ volumenTinta + "]";
	}

	public long getId_maquina() {
		return idMaquina;
	}

	public void setId_maquina(long idMaquina) {
		this.idMaquina = idMaquina;
	}

	public int getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(int fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public 	String getUbicacion() {
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

}
