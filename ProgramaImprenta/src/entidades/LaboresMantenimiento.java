package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class LaboresMantenimiento {
	private static int numLab = 0;
	private long idLab;
	private LocalDate FechaReal;
	private String Consistio;
	private String Maquina;
	private OpMaquina[] operarios;

	public static LaboresMantenimiento nuevoLaboresMantenimiento() {
		LaboresMantenimiento ret = new LaboresMantenimiento();
		numLab = numLab + 1;
		ret.idLab = numLab;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el Consistio:");
		ret.Consistio = teclado.nextLine();
		ret.setConsistio(ret.Consistio);

		Scanner teclado1 = new Scanner(System.in);
		System.out.println("Introduce la maquina:");
		ret.Maquina = teclado1.nextLine();
		ret.setMaquina(ret.Maquina);
		return ret;

	}

	public LaboresMantenimiento() {

	}
	

	public LaboresMantenimiento(long idLab, LocalDate FechaReal, String Consistio, String Maquina) {
		numLab = numLab + 1;
		this.idLab = numLab;
		this.FechaReal = FechaReal;
		this.Consistio = Consistio;
		this.Maquina = Maquina;

	}

	public long getIdLab() {
		return idLab;
	}

	public void setIdLab(long idLab) {
		this.idLab = idLab;
	}

	public LocalDate getFechaReal() {
		return FechaReal;
	}

	public void setFechaReal(LocalDate fechaReal) {
		FechaReal = fechaReal;
	}

	public String getConsistio() {
		return Consistio;
	}

	public void setConsistio(String consistio) {
		Consistio = consistio;
	}

	public String getMaquina() {
		return Maquina;
	}

	public void setMaquina(String maquina) {
		Maquina = maquina;
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
		return "LaboresMantenimiento [idLab=" + idLab + ", FechaReal=" + FechaReal + ", Consistio=" + Consistio
				+ ", Maquina=" + Maquina + ", operarios=" + Arrays.toString(operarios) + "]";
	}

}
