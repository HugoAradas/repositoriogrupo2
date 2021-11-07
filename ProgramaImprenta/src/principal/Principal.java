package principal;

import entidades.*;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente();
		cliente1 = Cliente.nuevoCliente();

		Departamento departamento1 = new Departamento();
		departamento1 = Departamento.nuevoDepartamento();

		LaboresMantenimiento labores1 = new LaboresMantenimiento();
		labores1 = LaboresMantenimiento.nuevoLaboresMantenimiento();

		Libro libro1 = new Libro();
		libro1 = Libro.nuevoLibro();

		Lote lote1 = new Lote();
		lote1 = Lote.nuevoLote();

		Maquina maquina1 = new Maquina();
		maquina1 = Maquina.nuevaMaquina();

		OpCalidad opcalidad1 = new OpCalidad();
		opcalidad1 = OpCalidad.nuevoOpCalidad();

		Operario operario1 = new Operario();
		operario1 = Operario.nuevoOperario();

		PoliticaCalidad politica1 = new PoliticaCalidad();
		politica1 = PoliticaCalidad.nuevaPolitica();

		Poster poster1 = new Poster();
		poster1 = Poster.nuevoPoster();

		Prueba prueba1 = new Prueba();
		prueba1 = Prueba.nuevaPrueba();

		ReglaCalidad regla1 = new ReglaCalidad();
		regla1 = ReglaCalidad.nuevaRegla();

		Rotulo rotulo1 = new Rotulo();
		rotulo1 = Rotulo.nuevoRotulo();

		Trabajo trabajo1 = new Trabajo();
		trabajo1 = Trabajo.nuevoTrabajo();

	}
}
