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

	public static boolean validarmaquina(long maquina) {
		if (maquina > 0) {
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

	public static boolean validaNif(String nif) {
		int tamanoNif = nif.length();
		if (tamanoNif == 9) {
			return true;

		} else {
			return false;
		}
	}

	public static boolean validanumtf(long telefono) {
		if (telefono <= 999999999 & telefono >= 900000000) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validardireccion(String direccion) {
		int tamanodireccion = direccion.length();
		if (tamanodireccion > 5 & tamanodireccion < 10) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarTipoRelieve(String tipoRelieve) {
		int tamanonombre = tipoRelieve.length();
		if (tamanonombre >= 3 & tamanonombre <= 25) {

			return true;

		} else {
			return false;
		}

	}

	public static boolean validarCentroComercial(String centroComercial) {
		int tamanonombre = centroComercial.length();
		if (tamanonombre >= 3 & tamanonombre <= 25) {

			return true;

		} else {
			return false;
		}

	}

	public static boolean validarExplicacion(String Explicacion) {
		int tamanonombre = Explicacion.length();
		if (tamanonombre >= 3 & tamanonombre <= 120) {

			return true;

		} else {
			return false;
		}

	}

	public static boolean validarResultado(String Resultado) {
		int tamanonombre = Resultado.length();
		if (tamanonombre >= 3 & tamanonombre <= 25) {

			return true;

		} else {
			return false;
		}

	}

	public static boolean validaancho(double ancho) {
		if (ancho < 100) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validaralto(double ancho) {
		if (ancho < 100) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void validarDNI(String DNI) throws DNIException {

        //Comprobamos la longitud del dni
        if (!(DNI.length() >= 8 && DNI.length() <= 9)) {
            throw new DNIException(DNIException.LONGITUD_NO_CORRECTA);
        }

        //saco la parte numerica
        String parte_numerica = DNI.substring(0, DNI.length() - 1);

        //Aqui guardare el dni
        int numeroDNI = 0;

        try {
            //Lo transformo en un numero
            //Puede saltar la excepcion
            numeroDNI = Integer.parseInt(parte_numerica);
        } catch (NumberFormatException e) {
            throw new DNIException(DNIException.PARTE_NUMERICA_NO_CORRECTA);
        }

        //
        char letra = DNI.substring(DNI.length() - 1, DNI.length()).toUpperCase().charAt(0);

        if (!(letra >= 'A' && letra <= 'Z')) {
            throw new DNIException(DNIException.PARTE_LETRA_NO_CORRECTA);
        }

        //Ya hemos validado el formato
        final int DIVISOR = 23;

        char letrasNIF[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        int resto = numeroDNI % DIVISOR;

        String nuevoDNI = numeroDNI + "" + letrasNIF[resto];

        if(DNI.startsWith("0")){
            nuevoDNI = "0"+nuevoDNI;
        }
        
        if (!(nuevoDNI.equals(DNI))) {
            throw new DNIException(DNIException.FORMATO_NO_CORRECTO);
        }

    }
}
