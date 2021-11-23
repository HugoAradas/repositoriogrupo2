package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class LaboresMantenimiento {
	private static int numLab = 0;
	private long idLab;
	private LocalDate FechaReal;
	private String Descripcion;
	private String Maquina;
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
		String maquina = "";
		boolean validamaquina = false;
		do {
			System.out.println("La maquina tiene que ser mas grande de 3 y menos de 15 caracteres");
			maquina = teclado.nextLine();
			validamaquina= validador.validarmaquina(maquina);
		} while (!validamaquina);
		ret.setMaquina(maquina);
		return ret;

	}

	public LaboresMantenimiento() {

	}
	

	public LaboresMantenimiento(long idLab, LocalDate FechaReal, String descripcion, String Maquina) {
		numLab = numLab + 1;
		this.idLab = numLab;
		this.FechaReal = FechaReal;
		this.Descripcion = descripcion;
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
		return Descripcion;
	}

	public void setConsistio(String consistio) {
		Descripcion = consistio;
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
		return "LaboresMantenimiento [idLab=" + idLab + ", FechaReal=" + FechaReal + ", Descripcion=" + Descripcion
				+ ", Maquina=" + Maquina + ", operarios=" + Arrays.toString(operarios) + "]";
	}

}
