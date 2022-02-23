package principal;

import entidades.*;
import utils.Datos;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);

		int menu = 0;
		boolean menuValido = false;
		boolean menuvalidoTrabajos = false;
		boolean menuvalidoMaquinas = false;
		boolean menuvalidoPersonal = false;

		do {
			System.out.println(
					"Selecciona un menú: \n 1. Gestión de trabajos \n 2. Gestión de máquinas \n 3. Gestión de presonal \n 4. Salir");
			menu = teclado.nextInt();
			menuValido = (menu < 1 || menu > 4 ? false : true);
			if (!menuValido) {
				System.out.println("introduce una opcion valida");
			}
			switch (menu) {
			case 1:
				System.out.println("Ha elegido 1. Gestión de trabajos");
				do {
					System.out.println(
							"Elige una opcion: \n 1.1. Ver trabajos \n 1.2. Nuevo trabajo \n 1.3. Buscar trabajo \n 0. Salir");
					menu = teclado.nextInt();
					menuvalidoTrabajos = (menu < 0 || menu > 3 ? false : true);
					if (!menuvalidoTrabajos) {
						System.out.println("introduce una opcion valida");
					}
					switch (menu) {
					case 1:
						System.out.println("Ha elegido 1.1. Ver trabajos");
						Trabajo.verTrabajos();
						menuvalidoTrabajos = false;
						break;
					case 2:
						System.out.println("Ha elegido 1.2. Nuevo trabajo");
						Trabajo.nuevoTrabajo();
						menuvalidoTrabajos = false;
						break;
					case 3:
						System.out.println("Ha elegido 1.3. Buscar trabajo");

						menuvalidoTrabajos = false;
						break;
					case 0:
						System.out.println("Ha elegido 0 Volver atrás");
						menuValido = false;
						break;

					}
				} while (!menuvalidoTrabajos);

				break;
			case 2:
				System.out.println("Ha elegido 2. Gestión de máquinas");
				do {
					System.out.println(
							"Elige una opcion: \n 2.1. Ver máquinas \n 2.2. Nueva máquina \n 2.3. Buscar máquina \n 0. Salir");
					menu = teclado.nextInt();
					menuvalidoMaquinas = (menu < 0 || menu > 3 ? false : true);
					if (!menuvalidoMaquinas) {
						System.out.println("introduce una opcion valida");
					}
					switch (menu) {
					case 1:
						System.out.println("Ha elegido 2.1. Ver máquinas");
						Maquina.verMaquinas();

						menuvalidoMaquinas = false;
						break;
					case 2:
						System.out.println("Ha elegido 2.2. Nueva máquina");
						Maquina.nuevaMaquina();

						menuvalidoMaquinas = false;
						break;
					case 3:
						System.out.println("Ha elegido 2.3. Buscar máquina");

						menuvalidoMaquinas = false;
						break;
					case 0:
						System.out.println("Ha elegido 0. Volver atrás");
						menuValido = false;
						break;

					}
				} while (!menuvalidoMaquinas);
				break;
			case 3:
				System.out.println("Ha elegido 3. Gestión de personal");
				do {
					System.out.println(
							"Elige una opcion: \n 3.1. Ver operarios \n 3.2. Nuevo operario \n 3.3. Buscar operario \n 0. Salir");
					menu = teclado.nextInt();
					menuvalidoPersonal = (menu < 0 || menu > 3 ? false : true);
					if (!menuvalidoPersonal) {
						System.out.println("introduce una opcion valida");
					}
					switch (menu) {
					case 1:
						System.out.println("Ha elegido 3.1. Ver operarios");
						Operario.verOperarios();

						menuvalidoPersonal = false;
						break;
					case 2:
						System.out.println("Ha elegido 3.2. Nuevo operario");
						Operario.nuevoOperario();
						
						menuvalidoPersonal = false;
						break;
					case 3:
						System.out.println("Ha elegido 3.3. Buscar operario");

						menuvalidoPersonal = false;
						break;
					case 0:
						System.out.println("Ha elegido o Volver atrás");
						menuValido = false;
						break;

					}
				} while (!menuvalidoPersonal);
				break;

			case 4:
				System.out.print("Ha elegido salir del programa, bye bye!");
				break;
			}

		} while (!menuValido);
	}

}
