package entidades;

import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Lote {
	// Variable auxiliar para asignar el id automaticamente
	public static int numLotes = 0;
	protected long idLote;
	protected String nombreLote;
	private Departamento[] Lugardep;

	public Lote() {
		numLotes = numLotes + 1;
		this.idLote = numLotes;
	}

	public static Lote nuevoLote() {
		Lote ret = null;
		Scanner teclado = new Scanner(System.in);
		long id = -1;
		Departamento lugarDep = null;
		boolean validaId = false;
		do {
			System.out.println("introduce el id del lote (>0)");
			id = teclado.nextInt();
			validaId = validador.validarId(id);
		} while (!validaId);

		String nombreLote = "";
		boolean validanombre = false;
		do {
			System.out.println("introduce el nombre del lote (mayor que 3 letras y menor que 15)");
			nombreLote = teclado.nextLine();
			validanombre = validador.validarnombre(nombreLote);

		} while (!validanombre);

		System.out.println("Introduce el departamento al que va a ir el lote");
		lugarDep = Departamento.nuevoDepartamento();

		ret = new Lote(id, nombreLote, lugarDep);
		return ret;
	}

	public Lote(long idLote, String nombreLote, Departamento Lugardep) {

	}

	public static int getNumLotes() {
		return numLotes;
	}

	public static void setNumLotes(int numLotes) {
		Lote.numLotes = numLotes;
	}

	public long getIdLote() {
		return idLote;
	}

	public void setIdLote(long idLote) {
		this.idLote = idLote;
	}

	public String getnombreLote() {
		return nombreLote;
	}

	public void setnombreLote(String nombreLote) {
		this.nombreLote = nombreLote;
	}

	public Departamento[] getLugardep() {
		return Lugardep;
	}

	public void setLugardep(Departamento[] Lugardep) {
		this.Lugardep = Lugardep;
	}

	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", nombreLote=" + nombreLote + ", Lugardep=" + Arrays.toString(Lugardep)
				+ "]";
	}

}
