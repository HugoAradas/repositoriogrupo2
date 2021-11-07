package entidades;

import java.util.Arrays;

public class ReglaCalidad {
	private static int numRegla = 0;
	private String NombreRegla;
	private long idPrueba;
	private long idRegla;
	private OpCalidad[] operarios;

	public ReglaCalidad() {
		numRegla = numRegla + 1;
		this.idRegla = numRegla;
	}

	public ReglaCalidad(String NombreRegla, long idPrueba, long idRegla) {
		numRegla = numRegla + 1;
		this.idRegla = numRegla;
		this.NombreRegla = NombreRegla;
		this.idPrueba = idPrueba;
	}

	public long getidRegla() {
		return idRegla;
	}

	public void setidRegla(long idRegla) {
		this.idRegla = idRegla;
	}
	
	public long getidPrueba() {
		return idPrueba;
	}

	public void setidPrueba(long idPrueba) {
		this.idPrueba = idPrueba;
	}
	
	public String getNombreRegla() {
		return NombreRegla;
	}

	public void setNombreRegla(String NombreRegla) {
		this.NombreRegla = NombreRegla;
	}

	public static int getNumRegla() {
		return numRegla;
	}

	public static void setNumRegla(int numRegla) {
		ReglaCalidad.numRegla = numRegla;
	}

	public OpCalidad[] getOperarios() {
		return operarios;
	}

	public void setOperarios(OpCalidad[] operarios) {
		this.operarios = operarios;
	}

	@Override
	public String toString() {
		return "ReglaCalidad [idPrueba=" + idPrueba + ", idRegla=" + idRegla + ", NombreRegla=" + NombreRegla
				+ ", operarios=" + Arrays.toString(operarios) + "]";
	}
}