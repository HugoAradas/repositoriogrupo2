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
		int tamañonombre = nombre.length();
		if (tamañonombre >= 3 & tamañonombre <= 13) {

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
		int tamañomaquina = maquina.length();
		if (tamañomaquina >= 10 & tamañomaquina <= 20) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarColorTapa(String color) {
		int tamañotapa = color.length();
		if (tamañotapa >= 4 & tamañotapa <= 10) {
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
		int tamañoubi = ubicacion.length();
		if (tamañoubi > 10 & tamañoubi < 20) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validamodoimpresion(String impresion) {
		int tamañoimpr = impresion.length();
		if (tamañoimpr > 5 & tamañoimpr < 10) {
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
		int tamañovalida = nombre.length();
		if (tamañovalida > 6 & tamañovalida > 14) {
			return true;
		} else {
			return false;
		}
	}
}
