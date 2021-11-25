package entidades;

import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class LaboresMantenimiento {
	private static int numLab = 0;
	private long idLab;
	private int FechaReal;
	private String Descripcion;
	private Maquina[] idMaquina;
	private OpMaquina[] operarios;

	public static LaboresMantenimiento nuevoLaboresMantenimiento() {
		LaboresMantenimiento ret = new LaboresMantenimiento();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el id de la Labor:");
		long id = -1;
		boolean validarId = false;
		do {
			System.out.println("introduce el id (>0)");
			id = teclado.nextLong();
			validarId = validador.validarId(id);
		} while (!validarId);
		ret.setIdLab(id);
		Scanner Teclado = new Scanner (System.in);
		System.out.println("introduce en que consistio la labor");
		ret.Descripcion = Teclado.nextLine();
		ret.setConsistio(ret.Descripcion);
		return ret;

	}

	public LaboresMantenimiento() {
		numLab = numLab + 1;
		this.idLab = numLab;
	}
	

	public LaboresMantenimiento(long idLab, int FechaReal, String descripcion, long idMaquina) {
		numLab = numLab + 1;
		this.idLab = idLab;
		this.FechaReal = FechaReal;
		this.Descripcion = descripcion;

	}

	public long getIdLab() {
		return idLab;
	}

	public void setIdLab(long idLab) {
		this.idLab = idLab;
	}

	public int getFechaReal() {
		return FechaReal;
	}

	public void setFechaReal(int fechaReal) {
		FechaReal = fechaReal;
	}

	public String getConsistio() {
		return Descripcion;
	}

	public void setConsistio(String consistio) {
		Descripcion = consistio;
	}

	public static int getNumLab() {
		return numLab;
	}

	public static void setNumLab(int numLab) {
		LaboresMantenimiento.numLab = numLab;
	}

	public OpMaquina[] getOperarios() {
		return operarios;
	}

	public void setOperarios(OpMaquina[] operarios) {
		this.operarios = operarios;
	}

	@Override
	public String toString() {
		return "LaboresMantenimiento [idLab=" + idLab + ", FechaReal=" + FechaReal + ", Descripcion=" + Descripcion
				+ ", Maquina=" + Arrays.toString(idMaquina) + ", operarios=" + Arrays.toString(operarios) + "]";
	}

}
