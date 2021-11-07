package entidades;

import java.time.LocalDate;
import java.util.Arrays;

public class Prueba {
	private static int numPrueba = 0;
	private LocalDate Fecha;
	private String Explicacion;
	private String Resultado;
	private long idMaquina;
	private long idPrueba;
	private OpCalidad[] operarios;

	public Prueba() {
		numPrueba = numPrueba + 1;
		this.idPrueba = numPrueba;
	}

	public Prueba(LocalDate Fecha, String Explicacion, String Resultado, long idMaquina, long idPrueba) {
		numPrueba = numPrueba + 1;
		this.idPrueba = numPrueba;
		this.Fecha = Fecha;
		this.Explicacion = Explicacion;
		this.Resultado = Resultado;
		this.idMaquina = idMaquina;
	}

	public long getidPrueba() {
		return idPrueba;
	}

	public void setidPrueba(long idPrueba) {
		this.idPrueba = idPrueba;
	}
	
	public long getidMaquina() {
		return idMaquina;
	}

	public void setidMaquina(long idMaquina) {
		this.idMaquina = idMaquina;
	}

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}

	public String getExplicacion() {
		return Explicacion;
	}

	public void setExplicacion(String explicacion) {
		Explicacion = explicacion;
	}

	public String getResultado() {
		return Resultado;
	}

	public void setResultado(String resultado) {
		Resultado = resultado;
	}

	public static int getNumPrueba() {
		return numPrueba;
	}

	public static void setNumPrueba(int numPrueba) {
		Prueba.numPrueba = numPrueba;
	}

	public OpCalidad[] getOperarios() {
		return operarios;
	}

	public void setOperarios(OpCalidad[] operarios) {
		this.operarios = operarios;
	}

	@Override
	public String toString() {
		return "Prueba [idPrueba=" + idPrueba + ", idMaquina=" + idMaquina + ", Fecha=" + Fecha + ", Explicacion=" + Explicacion
				+ ", Resultado=" + Resultado + ", operarios=" + Arrays.toString(operarios) + "]";
	}
}
