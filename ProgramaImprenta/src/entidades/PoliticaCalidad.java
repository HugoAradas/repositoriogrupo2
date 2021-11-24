package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class PoliticaCalidad {
	private long id;
	private static int numPol = 0;
	private String nombrePolitica;
	private LocalDate FechaVig;
	private String Descripcion;
	private OpCalidad[] operarios;

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
		ret.setDescripcion(descripcion);
		
		return ret;
	}

	public PoliticaCalidad(long idPol, LocalDate FechaVig, String Descripcion, String Resultado) {
		numPol = numPol + 1;
		this.nombrePolitica = nombrePolitica;
		this.FechaVig = FechaVig;
		this.Descripcion = Descripcion;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombrePolitica() {
		return nombrePolitica;
	}

	public void setNombrePolitica(String nombrePolitica2) {
		this.nombrePolitica = nombrePolitica2;
	}

	public LocalDate getFechaVig() {
		return FechaVig;
	}

	public void setFechaVig(LocalDate fechaVig) {
		FechaVig = fechaVig;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public static int getNumPol() {
		return numPol;
	}

	public static void setNumPol(int numPol) {
		PoliticaCalidad.numPol = numPol;
	}

	public OpCalidad[] getOperarios() {
		return operarios;
	}

	public void setOperarios(OpCalidad[] operarios) {
		this.operarios = operarios;
	}

	@Override
	public String toString() {
		return "PoliticaCalidad [NombrePolitica=" + nombrePolitica + ", FechaVig=" + FechaVig + ", Descripcion="
				+ Descripcion + ", operarios=" + Arrays.toString(operarios) + "]";
	}
}
