package entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import utils.Utilidades;
import validacion.validador;

public class LaboresMantenimiento {
	private static int numLab = 0;
	private long idLab;
	private LocalDate fechaReal;
	private String descripcion;
	private Maquina[] idMaquina;
	private OpMaquina[] idOperario;

	public static LaboresMantenimiento nuevoLaboresMantenimiento() {
		LaboresMantenimiento ret = null;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el id de la Labor:");
		long id = -1;
		String descripcion = "";
		LocalDate fechaReal = null;
		Maquina idMaquina = null;
		OpMaquina idOperario = null;
		
		
		boolean validarId = false;
		do {
			System.out.println("introduce el id (>0)");
			id = teclado.nextLong();
			validarId = validador.validarId(id);
		} while (!validarId);
		System.out.println("Introduce la fecha en la que se ejecutó la labor del matenimiento");
		LocalDate fecaReal = Utilidades.leerFecha();

		boolean validades = false;
		do {
			System.out.println("introduce una descripción valida");
			descripcion = teclado.next();
			validades = validador.validarExplicacion(descripcion);
		} while (!validades);

		System.out.println("introduce el id de la maquina a la que se la hace la labor");
		idMaquina = Maquina.nuevaMaquina();
		
		System.out.println("introduce el id del operario que lleva a cabo esta labor");
		idOperario = (OpMaquina) OpMaquina.nuevoOperario();
		ret = new LaboresMantenimiento (id, descripcion, fechaReal, idMaquina, idOperario);
		return ret;

	}

	public LaboresMantenimiento() {
		numLab = numLab + 1;
		this.idLab = numLab;
	}

	public LaboresMantenimiento(long id, String descripcion, LocalDate FechaReal, Maquina idMaquina,
			OpMaquina idOperario) {
		this.idLab = id;
		this.fechaReal = fechaReal;
		this.descripcion = descripcion;

	}


	public long getIdLab() {
		return idLab;
	}

	public void setIdLab(long idLab) {
		this.idLab = idLab;
	}

	public LocalDate getFechaReal() {
		return fechaReal;
	}

	public void setFechaReal(LocalDate fechaReal) {
		this.fechaReal = fechaReal;
	}

	public String getConsistio() {
		return descripcion;
	}

	public void setConsistio(String consistio) {
		descripcion = consistio;
	}

	public static int getNumLab() {
		return numLab;
	}

	public static void setNumLab(int numLab) {
		LaboresMantenimiento.numLab = numLab;
	}

	public OpMaquina[] getidOperario() {
		return idOperario;
	}

	public void setidOperario(OpMaquina[] idOperario) {
		this.idOperario = idOperario;
	}

	@Override
	public String toString() {
		return "LaboresMantenimiento [idLab=" + idLab + ", fechaReal=" + fechaReal + ", descripcion=" + descripcion
				+ ", idMaquina=" + Arrays.toString(idMaquina) + ", idOperario=" + Arrays.toString(idOperario) + "]";
	}

}
