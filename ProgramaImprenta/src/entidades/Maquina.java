package entidades;

import java.time.LocalDate;
import java.util.Scanner;

public class Maquina {
	// Variable auxiliar para asignar el id automaticamente
	public static int numMaquinas = 0;
	private long idMaquina;
	private LocalDate fecha_compra;
	private long ubicacion;
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
		numMaquinas = numMaquinas + 1;
		ret.idMaquina = numMaquinas;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la ubicacion:");
		ret.ubicacion = teclado.nextLong();
		ret.setUbicacion(ret.ubicacion);

		Scanner teclado1 = new Scanner(System.in);
		System.out.println("Introduce tipoImpresion:");
		ret.tipoImpresion = teclado1.nextLine();
		ret.setTipoImpresion(ret.tipoImpresion);

		Scanner teclado2 = new Scanner(System.in);
		System.out.println("Introduce modoImpresion:");
		ret.modoImpresion = teclado2.nextLine();
		ret.setModoImpresion(ret.modoImpresion);

		Scanner teclado3 = new Scanner(System.in);
		System.out.println("Introduce volumenTinta:");
		ret.volumenTinta = teclado3.nextDouble();
		ret.setVolumenTinta(ret.volumenTinta);
		return ret;
	}

//Constructor por atributos de Maquina
	public Maquina(long idMaquina, LocalDate fecha_compra, long ubicacion) {
		numMaquinas = numMaquinas + 1;
		this.idMaquina = numMaquinas;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la ubicacion:");
		ubicacion = teclado.nextLong();
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

	public LocalDate getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(LocalDate fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public long getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(long ubicacion) {
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
