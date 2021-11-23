package validacion;

public class validador {

	public static boolean validarId(long id) {
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarnombre(String nombre) {
		int tamanonombre = nombre.length();
		if (tamanonombre >= 3 & tamanonombre <= 13) {

			return true;

		} else {
			return false;
		}

	}

	public static boolean validarapellido(String apellido) {
		boolean espacio = false;
		if (apellido != null) {
			boolean separacion = apellido.contains(" ");
			espacio = (separacion == true);
		}
		return espacio;
	}

	public static boolean validarmaquina(String maquina) {
		int tamanomaquina = maquina.length();
		if (tamanomaquina >= 10 & tamanomaquina <= 20) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarColorTapa(String color) {
		int tamanotapa = color.length();
		if (tamanotapa >= 4 & tamanotapa <= 10) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarnumcopias(int numcopias) {
		if (numcopias > 0) {
			return true;

		} else {
			return false;
		}
	}

	public static boolean validaubicacion(String ubicacion) {
		int tamanoubi = ubicacion.length();
		if (tamanoubi > 10 & tamanoubi < 20) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validamodoimpresion(String impresion) {
		int tamanoimpr = impresion.length();
		if (tamanoimpr > 5 & tamanoimpr < 10) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validavolumentinta(double volumentinta) {
		if (volumentinta > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validapolitica(String nombre) {
		int tamanovalida = nombre.length();
		if (tamanovalida > 6 & tamanovalida > 14) {
			return true;
		} else {
			return false;
		}
	}
}
