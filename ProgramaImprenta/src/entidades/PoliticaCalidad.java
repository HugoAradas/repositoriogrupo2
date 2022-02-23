package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class PoliticaCalidad {
	private long idPolitica;
	private static int numPol = 0;
	private String nombrePolitica;
	private LocalDate fechaVig;
	private String descripcion;
	private OpCalidad[] idOperario;
	private ReglaCalidad[] idRegla;

	public PoliticaCalidad() {
		numPol = numPol + 1;

	}

	public static PoliticaCalidad nuevaPolitica() {
		PoliticaCalidad ret = new PoliticaCalidad();
		Scanner teclado = new Scanner(System.in);
		long id = -1;
		boolean validaid = false;
		do {
			System.out.println("El id del cliente tiene que ser siempre mayor que cero");
			id = teclado.nextLong();
			validaid = validador.validarId(id);
		}while (!validaid);
		ret.setId(id);
		String nombrePolitica = "";
		boolean validanombre = false; 
		do {
			System.out.println("introduce un nombre de politica (>= 3 o <=13 palabras)");
			nombrePolitica = teclado.nextLine();
			validanombre = validador.validarnombre(nombrePolitica);
		} while (!validanombre);
		ret.setNombrePolitica(nombrePolitica);
		
		String descripcion = "";
		boolean validadescripcion = false; 
		do {
			System.out.println("introduce una descripcion de mas de 3 letras y menos de 120");
			descripcion = teclado.next();
			validadescripcion = validador.validarExplicacion(descripcion);
		} while (!validadescripcion);
		ret.setdescripcion(descripcion);
		
		return ret;
	}

	public PoliticaCalidad(long idPol, String nombrePolitica, LocalDate fechaVig, String descripcion, String Resultado, OpCalidad idOperario,
			ReglaCalidad idRegla, ReglaCalidad idRegla1) {
		numPol = numPol + 1;
		this.nombrePolitica = nombrePolitica;
		this.fechaVig = fechaVig;
		this.descripcion = descripcion;
	}
	

	public long getId() {
		return idPolitica;
	}

	public void setId(long id) {
		this.idPolitica = id;
	}

	public String getNombrePolitica() {
		return nombrePolitica;
	}

	public void setNombrePolitica(String nombrePolitica2) {
		this.nombrePolitica = nombrePolitica2;
	}

	public LocalDate getfechaVig() {
		return fechaVig;
	}

	public void setfechaVig(int fechaVig) {
		fechaVig = fechaVig;
	}

	public String getdescripcion() {
		return descripcion;
	}

	public void setdescripcion(String descripcion) {
		descripcion = descripcion;
	}

	public static int getNumPol() {
		return numPol;
	}

	public static void setNumPol(int numPol) {
		PoliticaCalidad.numPol = numPol;
	}

	public OpCalidad[] getidOperario() {
		return idOperario;
	}

	public void setidOperario(OpCalidad[] idOperario) {
		this.idOperario = idOperario;
	}

	public ReglaCalidad[] getidRegla() {
		return idRegla;
	}

	public void setidRegla(ReglaCalidad[] idRegla) {
		this.idRegla = idRegla;
	}

	@Override
	public String toString() {
		return  idPolitica + "|" + nombrePolitica + "|" + fechaVig + "|" + descripcion + "|" + idOperario + "|" + idRegla;
	}
}
