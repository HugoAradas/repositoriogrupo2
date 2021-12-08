package principal;

import entidades.*;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Programa de gestion de una imprenta ");
		int menu = 0;
		boolean menuValido = false;
		boolean menuvalidoTrabajo = false;
		boolean menuvalidoMaquina = false;
		boolean menuvalidoPersonal = false;
		do {
			System.out.println(
					"Elige una opcion: \n 1. Gestion de trabajos \n 2. Gestión de máquinas \n 3. Gestión de personal \n 4. Salir ");
			menu = teclado.nextInt();
			menuValido = (menu < 1 || menu > 5 ? false : true);
			if (!menuValido) {
				System.out.println("introduce una opcion valida");
			}
			switch (menu) {
			case 1:
				System.out.println("Ha elegido 1. Gestión de trabajos");
				do {
					System.out.println(
							"Elige una opcion: \n 1. Ver trabajos \n 2. Nuevo trabajo \n 3. Buscar trabajo \n 4. Volver atrás ");
					menu = teclado.nextInt();
					menuvalidoTrabajo = (menu < 1 || menu > 5 ? false : true);
					if (!menuvalidoTrabajo) {
						System.out.println("introduce una opcion valida");
					}
					switch (menu) {
					case 1:
						System.out.println("Ha elegido 1.1. Ver trabajos");
						System.out.println("----------------------------");
						Trabajo.mostrarTrabajo();

						break;
					case 2:
						System.out.println("Ha elegido 1.2. Nuevo trabajo \n");
						Trabajo trabajo1 = new Trabajo();
						trabajo1 = Trabajo.nuevoTrabajo();
						System.out.println("Has creado el siguiente trabajo : " + trabajo1);
						break;
					case 3:
						System.out.println("Ha elegido 1.3. Buscar trabajo");
						break;
					case 4:
						System.out.println("Ha elegido 1.4. Volver atrás");
						break;

					}
				} while (!menuvalidoTrabajo);

				break;
			case 2:
				System.out.println("Ha elegido 2. Gestión de máquinas");
				do {
					System.out.println(
							"Elige una opcion: \n 1. Ver máquinas \n 2. Nueva máquina/ lote \n 3. Buscar máquina \n 4. Volver atrás ");
					menu = teclado.nextInt();
					menuvalidoTrabajo = (menu < 1 || menu > 5 ? false : true);
					if (!menuvalidoMaquina) {
						System.out.println("introduce una opcion valida");
					}
					switch (menu) {
					case 1:
						System.out.println("Ha elegido 2.1. Ver máquinas");

						break;
					case 2:
						System.out.println("Ha elegido 2.2. Nueva máquina / lote \n");

						System.out.println("Elege una nueva máquina \n  ");
						Maquina maquina1 = new Maquina();
						maquina1 = Maquina.nuevaMaquina();
						System.out.println("Elegiste la máquina  " + maquina1);

						System.out.println("Elege un nuevo lote \n  ");
						Lote lote1 = new Lote();
						lote1 = Lote.nuevoLote();
						System.out.println("Elegiste el siguiente lote" + lote1);

						break;
					case 3:
						System.out.println("Ha elegido 2.3. Buscar máquina");
						break;
					case 4:
						System.out.println("Ha elegido 2.4. Volver atrás");
						break;

					}
				} while (!menuvalidoMaquina);
				break;
			case 3:
				System.out.println("Ha elegido 3. Gestión de personal");
				do {
					System.out.println(
							"Elige una opcion: \n 1. Ver operario \n 2. Nuevo operario \n 3. Buscar operario \n 4. Volver atrás ");
					menu = teclado.nextInt();
					menuvalidoTrabajo = (menu < 1 || menu > 5 ? false : true);
					if (!menuvalidoPersonal) {
						System.out.println("introduce una opcion valida");
					}
					switch (menu) {
					case 1:
						System.out.println("Ha elegido 3.1. Ver operario");

						break;
					case 2:
						System.out.println("Ha elegido 3.2. Nuevo operario \n");
						
						Operario operario1 = new Operario();
						operario1 = Operario.nuevoOperario();
						
						System.out.println("Has elegido el siguiente operario" + operario1);
						
						
						break;
					case 3:
						System.out.println("Ha elegido 3.3. Buscar operario");
						
						
						break;
					case 4:
						System.out.println("Ha elegido 3.4. Volver atrás");
						break;

					}
				} while (!menuvalidoPersonal);
				break;
			case 4:
				System.out.println("Ha elegido 4. salir \n bye bye");
				break;

			}
		} while (!menuValido);
//		Cliente cliente1 = new Cliente();
//		cliente1 = Cliente.nuevoCliente();
//
//		Departamento departamento1 = new Departamento();
//		departamento1 = Departamento.nuevoDepartamento();
//
//		LaboresMantenimiento labores1 = new LaboresMantenimiento();
//		labores1 = LaboresMantenimiento.nuevoLaboresMantenimiento();
//
//		Libro libro1 = new Libro();
//		libro1 = Libro.nuevoLibro();
//
//		Maquina maquina1 = new Maquina();
//		maquina1 = Maquina.nuevaMaquina();
//
//		OpCalidad opcalidad1 = new OpCalidad();
//		opcalidad1 = OpCalidad.nuevoOpCalidad();
//
//
//
//		PoliticaCalidad politica1 = new PoliticaCalidad();
//		politica1 = PoliticaCalidad.nuevaPolitica();
//
//		Poster poster1 = new Poster();
//		poster1 = Poster.nuevoPoster();
//
//		Prueba prueba1 = new Prueba();
//		prueba1 = Prueba.nuevaPrueba();
//
//		ReglaCalidad regla1 = new ReglaCalidad();
//		regla1 = ReglaCalidad.nuevaRegla();
//
//		Rotulo rotulo1 = new Rotulo();
//		rotulo1 = Rotulo.nuevoRotulo();
//
//		Trabajo trabajo1 = new Trabajo();
//		trabajo1 = Trabajo.nuevoTrabajo();

	}
}
