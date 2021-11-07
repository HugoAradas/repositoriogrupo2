package entidades;

import java.time.LocalDate;
import java.util.Arrays;

public class PoliticaCalidad {
	private static int numPol = 0;
	private long NombrePolitica;
	private LocalDate FechaVig;
	private String Descripcion;
	private OpCalidad[] operarios;

	public PoliticaCalidad() {
		numPol = numPol + 1;
		this.NombrePolitica = numPol;
	}

	public PoliticaCalidad(long idPol, LocalDate FechaVig, String Descripcion, String Resultado) {
		numPol = numPol + 1;
		this.NombrePolitica = numPol;
		this.FechaVig = FechaVig;
		this.Descripcion = Descripcion;
	}

	public long getNombrePolitica() {
		return NombrePolitica;
	}

	public void setNombrePolitica(long NombrePolitica) {
		this.NombrePolitica = NombrePolitica;
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
		return "PoliticaCalidad [NombrePolitica=" + NombrePolitica + ", FechaVig=" + FechaVig + ", Descripcion=" + Descripcion
				+ ", operarios=" + Arrays.toString(operarios) + "]";
	}
}
