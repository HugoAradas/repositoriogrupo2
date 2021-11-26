package entidades;

import validacion.*;
import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class ReglaCalidad {
	private static int numRegla = 0;
	// mínimo 3 caracteres, máximo 25
	private String NombreRegla;
	// valor mínimo 1
	protected long idRegla;
	private OpCalidad[] operarios;
	private Prueba[] idPrueba;

	public ReglaCalidad() {
		numRegla = numRegla + 1;
		this.idRegla = numRegla;
	}

	public static ReglaCalidad nuevaRegla() {
		numRegla = numRegla + 1;
		ReglaCalidad ret = new ReglaCalidad();
		ret.idRegla = numRegla;
		Scanner teclado = new Scanner(System.in);

		boolean nombreReglaValido = false;
		do {
			System.out.println("Introduce el nombre de la nueva regla");
			ret.NombreRegla = teclado.nextLine();
			nombreReglaValido = validador.validarnombre(ret.NombreRegla);
		} while (!nombreReglaValido);

		return ret;
	}

	public ReglaCalidad(String NombreRegla, long idRegla, long idPrueba, long idPrueba1, long idPrueba2) {
		numRegla = numRegla + 1;
		this.idRegla = numRegla;
		this.NombreRegla = NombreRegla;
	}

	public long getidRegla() {
		return idRegla;
	}

	public void setidRegla(long idRegla) {
		this.idRegla = idRegla;
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

	public long getIdRegla() {
		return idRegla;
	}

	public void setIdRegla(long idRegla) {
		this.idRegla = idRegla;
	}

	public Prueba[] getidPrueba() {
		return idPrueba;
	}

	public void setidPrueba(Prueba[] idPrueba) {
		this.idPrueba = idPrueba;
	}

	@Override
	public String toString() {
		return "ReglaCalidad [idRegla=" + idRegla + ", NombreRegla=" + NombreRegla
				+ ", operarios=" + Arrays.toString(operarios) + ", idPrueba=" + Arrays.toString(idPrueba) + "]";
	}
}