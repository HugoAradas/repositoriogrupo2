package entidades;

import java.util.Arrays;
import java.util.Scanner;

import validacion.validador;

public class Lote {
	// Variable auxiliar para asignar el id automaticamente
	public static int numLotes = 0;
	private long idLote;
	private String nombreLote;
	private Departamento[] Lugardep;

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
		
		String nombreLote ="";
		boolean validanombre = false; 
		do {
			System.out.println("introduce el nombre del lote (mayor que 3 letras y menor que 15)");
			nombreLote = teclado.nextLine();
			validanombre = validador.validarnombre(nombreLote);
			
		} while (!validanombre);
		ret.setnombreLote(nombreLote);
		
		long idmaquina = -1;
		boolean validaid= false;
		do {
			System.out.println("introduce el id donde esta asociada la maquina");
			idmaquina = teclado.nextInt();
			validaid = validador.validarId(idmaquina);
		} while (!validaid);
		return ret;
	}

	public Lote(long idLote, String nombreLote, Departamento Lugardep) {
		numLotes = numLotes + 1;
		this.idLote = numLotes;
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
		return "Lote [idLote=" + idLote + ", nombreLote=" + nombreLote + ", Lugardep=" + Arrays.toString(Lugardep) + "]";
	}

}
