package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Prueba {
	private static int numPrueba = 0;
	private LocalDate Fecha;
	// entre 3 y 120 caracteres
	private String Explicacion;
	// entre 3 y 120 caracteres
	private String Resultado;
	// valor mínimo 1
	private long idMaquina;
	// valor mínimo 1
	private long idPrueba;
	private OpCalidad[] operarios;

	public Prueba() {
		numPrueba = numPrueba + 1;
		this.idPrueba = numPrueba;
	}

	public static Prueba nuevaPrueba() {
		numPrueba = numPrueba + 1;
		Prueba ret = new Prueba();
		ret.idPrueba = numPrueba;
		Scanner teclado = new Scanner(System.in);

		boolean explicacionValida = false;
		do {
			System.out.println("Introduce la explicacion de la prueba");
			ret.Explicacion = teclado.next();
			explicacionValida = validador.validarExplicacion(ret.Explicacion);
		} while (!explicacionValida);

		boolean resultadoValido = false;
		do {
			System.out.println("Introduce el resultado de la prueban");
			ret.Resultado = teclado.next();
			resultadoValido = validador.validarResultado(ret.Resultado);
		} while (!resultadoValido);

		boolean idValido = false;
		do {
			System.out.println("Introduce el id de la maquina sobre la que se realiza la prueba");
			ret.idMaquina = teclado.nextLong();
			idValido = validador.validarId(ret.idMaquina);
		} while (!idValido);

		return ret;
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
		return "Prueba [idPrueba=" + idPrueba + ", idMaquina=" + idMaquina + ", Fecha=" + Fecha + ", Explicacion="
				+ Explicacion + ", Resultado=" + Resultado + ", operarios=" + Arrays.toString(operarios) + "]";
	}
}
