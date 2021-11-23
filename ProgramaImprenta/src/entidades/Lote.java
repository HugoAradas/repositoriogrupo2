package entidades;

import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Lote {
	// Variable auxiliar para asignar el id automaticamente
	public static int numLotes = 0;
	private long idLote;
	private int numeroDeLote;
	// id de la maquina debido a la relacion entre maquina y lote
	private Maquina[] maquinas;
	private Departamento[] departamentos;

	public Lote() {
		numLotes = numLotes + 1;
		this.idLote = numLotes;
	}

	public static Lote nuevoLote() {
		Lote ret = new Lote();
		Scanner teclado = new Scanner(System.in);
		long id = -1;
		boolean validaId = false;
		do {
			System.out.println("introduce el id del lote (>0)");
			id = teclado.nextInt();
			validaId = validador.validarId(id);
		} while (!validaId);
		ret.setIdLote(id);
		int numlote = -1;
		boolean validanumlote = false;
		do {
			System.out.println("introduce un numero de lote (>0)");
			numlote = teclado.nextInt();
			validanumlote = validador.validarnumcopias(numlote);
		} while (!validanumlote);
		System.out.println("Introduce el numeroDeLote");
		ret.numeroDeLote = teclado.nextInt();
		ret.setNumeroDeLote(ret.numeroDeLote);
		long idmaquina = -1;
		boolean validaid= false;
		do {
			System.out.println("introduce el id donde esta asociada la maquina");
			idmaquina = teclado.nextInt();
			validaid = validador.validarId(idmaquina);
		} while (!validaid);
		return ret;
	}

	public Lote(long idLote, int numeroDeLote) {
		numLotes = numLotes + 1;
		this.idLote = numLotes;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el numeroDeLote");
		numeroDeLote = teclado.nextInt();
		setNumeroDeLote(numeroDeLote);
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

	public Maquina[] getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(Maquina[] maquinas) {
		this.maquinas = maquinas;
	}

	public int getNumeroDeLote() {
		return numeroDeLote;
	}

	public void setNumeroDeLote(int numeroDeLote) {
		this.numeroDeLote = numeroDeLote;
	}

	public Departamento[] getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamento[] departamentos) {
		this.departamentos = departamentos;
	}

	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", numeroDeLote=" + numeroDeLote + ", maquinas=" + Arrays.toString(maquinas)
				+ ", departamentos=" + Arrays.toString(departamentos) + "]";
	}

}
