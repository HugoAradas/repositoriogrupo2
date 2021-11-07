package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class PoliticaCalidad {
	private static int numPol = 0;
	private String NombrePolitica;
	private LocalDate FechaVig;
	private String Descripcion;
	private OpCalidad[] operarios;

	public PoliticaCalidad() {
		numPol = numPol + 1;

	}

	public static PoliticaCalidad nuevaPolitica() {
		PoliticaCalidad ret = new PoliticaCalidad();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el nombre de la politica");
		ret.NombrePolitica = teclado.nextLine();
		ret.setNombrePolitica(ret.NombrePolitica);
		System.out.println("Introduce la descripcion de la politica de calidad");
		ret.Descripcion = teclado.next();
		ret.setDescripcion(ret.Descripcion);
		return ret;
	}

	public PoliticaCalidad(long idPol, LocalDate FechaVig, String Descripcion, String Resultado) {
		numPol = numPol + 1;
		this.NombrePolitica = NombrePolitica;
		this.FechaVig = FechaVig;
		this.Descripcion = Descripcion;
	}

	public String getNombrePolitica() {
		return NombrePolitica;
	}

	public void setNombrePolitica(String nombrePolitica2) {
		this.NombrePolitica = nombrePolitica2;
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
		return "PoliticaCalidad [NombrePolitica=" + NombrePolitica + ", FechaVig=" + FechaVig + ", Descripcion="
				+ Descripcion + ", operarios=" + Arrays.toString(operarios) + "]";
	}
}
