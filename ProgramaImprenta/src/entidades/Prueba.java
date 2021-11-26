package entidades;

import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Prueba {
	private static int numPrueba = 0;
	private int Fecha;
	// entre 3 y 120 caracteres
	private String Explicacion;
	// entre 3 y 120 caracteres
	private String Resultado;
	// valor mínimo 1
	protected long idPrueba;
	private OpCalidad[] idOperario;
	private Maquina [] idMaquina;

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

		return ret;
	}

	public Prueba(int Fecha, String Explicacion, String Resultado, long idPrueba, long idOperario) {
		numPrueba = numPrueba + 1;
		this.idPrueba = numPrueba;
		this.Fecha = Fecha;
		this.Explicacion = Explicacion;
		this.Resultado = Resultado;
	}

	public long getidPrueba() {
		return idPrueba;
	}

	public void setidPrueba(long idPrueba) {
		this.idPrueba = idPrueba;
	}

	public Maquina[] getidMaquina() {
		return idMaquina;
	}

	public void setidMaquina(Maquina[] idMaquina) {
		this.idMaquina = idMaquina;
	}

	public int getFecha() {
		return Fecha;
	}

	public void setFecha(int fecha) {
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

	public OpCalidad[] getidOperario() {
		return idOperario;
	}

	public void setidOperario(OpCalidad[] idOperario) {
		this.idOperario = idOperario;
	}

	@Override
	public String toString() {
		return "Prueba [idPrueba=" + idPrueba + ", idMaquina=" + idMaquina + ", Fecha=" + Fecha + ", Explicacion="
				+ Explicacion + ", Resultado=" + Resultado + ", idOperario=" + Arrays.toString(idOperario) + "]";
	}
}
