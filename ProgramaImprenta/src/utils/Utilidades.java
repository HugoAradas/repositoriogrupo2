package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Utilidades {
	public static final int TAM  = 100;
	 public static java.sql.Date leerFecha() {
	        Date ret = null;
	        int dia, mes, anio;
	        boolean correcto = false;
	        Scanner in;
	        do {
	            System.out.println("Introduzca un valor para el día (1...31)");
	            in = new Scanner(System.in, "ISO-8859-1");
	            dia = in.nextInt();
	            System.out.println("Introduzca un valor para el mes (1...12)");
	            in = new Scanner(System.in, "ISO-8859-1");
	            mes = in.nextInt();
	            System.out.println("Introduzca un valor para el año");
	            in = new Scanner(System.in, "ISO-8859-1");
	            anio = in.nextInt();

	            try {
	                ret = Date.valueOf(LocalDate.of(anio, mes, dia));
	                correcto = true;
	            } catch (Exception e) {
	                System.out.println("Fecha introducida incorrecta.");
	                correcto = false;
	            }
	        } while (!correcto);
	        return ret;
	    }
}
