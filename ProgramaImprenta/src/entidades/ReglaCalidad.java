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
	private OpCalidad[] idOperario;
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

	public ReglaCalidad(String NombreRegla, long idRegla, Prueba idPrueba, Prueba idPrueba1, Prueba idPrueba2, OpCalidad idOperario) {
		numRegla = numRegla + 1;
		this.idRegla = numRegla;
		this.NombreRegla = NombreRegla;
	}

	public ReglaCalidad(long idRegla, OpCalidad[] idOperario, Prueba[] idPrueba) {
		super();
		this.idRegla = idRegla;
		this.idOperario = idOperario;
		this.idPrueba = idPrueba;
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

	public OpCalidad[] getidOperario() {
		return idOperario;
	}

	public void setidOperario(OpCalidad[] idOperario) {
		this.idOperario = idOperario;
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
		return idRegla + "|" + NombreRegla + "|" + idOperario + "|" + idPrueba;
	}
}