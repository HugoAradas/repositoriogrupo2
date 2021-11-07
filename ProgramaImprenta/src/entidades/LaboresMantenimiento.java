package entidades;

import java.time.LocalDate;
import java.util.Arrays;

public class LaboresMantenimiento {
	private static int numLab = 0;
	private long idLab;
	private LocalDate FechaReal;
	private String Consistio;
	private String Maquina;
	private OpMaquina[] operarios;

	public LaboresMantenimiento() {
		numLab = numLab + 1;
		this.idLab = numLab;

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
