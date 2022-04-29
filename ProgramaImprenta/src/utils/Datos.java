package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entidades.*;

public class Datos {

	public static final Cliente CLIENTES[] = { new Cliente(1, "Juan", "Golondrina"),
			new Cliente(2, "Rufina", "Gonzalez"), new Cliente(3, "Jose", "Gonzalez") };
	public static final int numClientes = CLIENTES.length;

	public static final Departamento DEPARTAMENTOS[] = { new Departamento('A'), new Departamento('B'),
			new Departamento('C') };
	public static final int numDepartamento = DEPARTAMENTOS.length;

	public static final Lote LOTES[] = { new Lote(1, "Lote1", DEPARTAMENTOS[0]), new Lote(2, "Lote2", DEPARTAMENTOS[1]),
			new Lote(3, "Lote3", DEPARTAMENTOS[2]) };
	public static final int numLote = LOTES.length;

	public static final Operario OPERARIOS[] = {
//			new Operario(1, "83492590M", "Benito", "Garcia", 682749158, "Gijon", DEPARTAMENTOS[0]),
//			new Operario(2, "83497256J", "Juan", "Perez", 639674539, "Barcelona", DEPARTAMENTOS[0]),
//			new Operario(3, "72912597P", "Jose", "Fernandez", 639284027, "Valladolid", DEPARTAMENTOS[1]),
//			new Operario(4, "25840183M", "Sandra", "Martinez", 684038275, "Toledo", DEPARTAMENTOS[2]),
//			new Operario(5, "72675927F", "Borja", "Rojo", 616803247, "Cordoba", DEPARTAMENTOS[2]),
//			new Operario(6, "27492027D", "Andrea", "Rubia", 673402184, "Caceres", DEPARTAMENTOS[0]),
//			new Operario(7, "19473502M", "Aitor", "Ali", 698723688, "Madrid", DEPARTAMENTOS[2]),
//			new Operario(8, "32856382K", "Ruben", "Yamaoka", 638502850, "Murcia", DEPARTAMENTOS[1]),
			new Operario(9, "83620174H", "Ana", "Fernandez", 699472958, "Gijon", false, DEPARTAMENTOS[2]) };
	public static final int numOperarios = OPERARIOS.length;

//	public static final OpImpresion OPSIMPRESION[] = { new OpImpresion(3, "72912597P", "JoseFernandez", 1),
//			new OpImpresion(7, "19473502M", "AitorAli", 2), new OpImpresion(1, "83492590M", "BenitoGarcia", 3) };
//	public static final int numOpImpresion = OPSIMPRESION.length;

//	public static final OpMaquina OPSMAQUINA[] = { new OpMaquina(OPERARIOS[2], "83497256J", "JuanPerez"),
//			new OpMaquina(OPERARIOS[8], "32856382K", "RubenYamaoka"),
//			new OpMaquina(OPERARIOS[8], "83620174H", "AnaFernandez") };
//	public static final int numOpMaquina = OPSMAQUINA.length;

	public static final Maquina MAQUINAS[] = { 
			new Maquina(1, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Sotano",  "", "", 9.7, LOTES[1]),
			new Maquina(2, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Sotano",  "", "", 9.7, LOTES[1]), 
			new Maquina(3, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "P1",  "", "", 9.7, LOTES[0]),
			new Maquina(4, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "P1",  "", "", 9.7, LOTES[0]), 
			new Maquina(5, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "P2",  "", "", 9.7, LOTES[2]),
			new Maquina(6, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "P2",  "", "", 9.7, LOTES[2]) };
	public static final int numMaquina = MAQUINAS.length;

//	public static final LaboresMantenimiento LABORES[] = {
//			new LaboresMantenimiento(1, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Descripcion", MAQUINAS[1], OPSMAQUINA[2]),
//			new LaboresMantenimiento(2, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Descripcion", MAQUINAS[2], OPSMAQUINA[0]),
//			new LaboresMantenimiento(3, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Descripcion", MAQUINAS[3], OPSMAQUINA[1]) };
//	public static final int numLabor = LABORES.length;

	public static final OpCalidad OPSCALIDAD[] = { new OpCalidad(OPERARIOS[6], "83492590M", "BenitoGarcia"),
			new OpCalidad(OPERARIOS[4], "25840183M", "SandraMartinez"),
			new OpCalidad(OPERARIOS[5], "72675927F", "BorjaRojo") };
	public static final int numOpCalidad = OPSCALIDAD.length;

	public static final Prueba PRUEBAS[] = {
			new Prueba(1, OPSCALIDAD[0], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[1]),
			new Prueba(2, OPSCALIDAD[1], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[3]),
			new Prueba(3, OPSCALIDAD[2], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[4]),
			new Prueba(4, OPSCALIDAD[0], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[3]),
			new Prueba(5, OPSCALIDAD[2], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[3]),
			new Prueba(6, OPSCALIDAD[1], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[5]),
			new Prueba(7, OPSCALIDAD[0], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[4]),
			new Prueba(8, OPSCALIDAD[2], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[1]),
			new Prueba(9, OPSCALIDAD[1], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[1]),
			new Prueba(10, OPSCALIDAD[2], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[2]),
			new Prueba(11, OPSCALIDAD[1], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[5]),
			new Prueba(12, OPSCALIDAD[0], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[4]),
			new Prueba(13, OPSCALIDAD[1], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[3]),
			new Prueba(14, OPSCALIDAD[0], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[5]),
			new Prueba(15, OPSCALIDAD[2], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[1]),
			new Prueba(16, OPSCALIDAD[1], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[3]),
			new Prueba(17, OPSCALIDAD[2], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[4]),
			new Prueba(18, OPSCALIDAD[0], LocalDate.parse("26/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Explicacion", "Resultado", MAQUINAS[1]), };
	public static final int numPrueba = PRUEBAS.length;

	public static final ReglaCalidad REGLAS[] = {
			new ReglaCalidad("Regla1", 1, PRUEBAS[1], PRUEBAS[2], PRUEBAS[3], OPSCALIDAD[1]),
			new ReglaCalidad("Regla2", 2, PRUEBAS[4], PRUEBAS[5], PRUEBAS[6], OPSCALIDAD[2]),
			new ReglaCalidad("Regla3", 3, PRUEBAS[7], PRUEBAS[8], PRUEBAS[9], OPSCALIDAD[0]),
			new ReglaCalidad("Regla4", 4, PRUEBAS[10], PRUEBAS[11], PRUEBAS[12], OPSCALIDAD[2]),
			new ReglaCalidad("Regla3", 5, PRUEBAS[13], PRUEBAS[14], PRUEBAS[15], OPSCALIDAD[0]),
			new ReglaCalidad("Regla3", 6, PRUEBAS[16], PRUEBAS[17], PRUEBAS[17], OPSCALIDAD[1]), };
	public static final int numRegla = REGLAS.length;

	public static final PoliticaCalidad POLITICAS[] = {
			new PoliticaCalidad(1, "Numero1", LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Descripcion", "Resultado", OPSCALIDAD[0], REGLAS[1],
					REGLAS[2]),
			new PoliticaCalidad(2, "Numero2", LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Descripcion", "Resultado", OPSCALIDAD[1], REGLAS[3],
					REGLAS[4]),
			new PoliticaCalidad(3, "Numero3", LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Descripcion", "Resultado", OPSCALIDAD[2], REGLAS[5],
					REGLAS[1]), };
	public static final int numPolitica = POLITICAS.length;

	public static final Trabajo TRABAJOS[] = {
			new Trabajo(1, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Liso", CLIENTES[1],
					MAQUINAS[1]),
			new Trabajo(2, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Rugoso", CLIENTES[1],
					MAQUINAS[3]),
			new Trabajo(3, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Liso", CLIENTES[2],
					MAQUINAS[3]),
			new Trabajo(4, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Rugoso", CLIENTES[1],
					MAQUINAS[1]),
			new Trabajo(5, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Liso", CLIENTES[2],
					MAQUINAS[3]),
			new Trabajo(6, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Liso", CLIENTES[0],
					MAQUINAS[2]),
			new Trabajo(7, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Liso", CLIENTES[1],
					MAQUINAS[1]),
			new Trabajo(8, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Rugoso", CLIENTES[2],
					MAQUINAS[1]),
			new Trabajo(9, LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("25/11/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Liso", CLIENTES[0],
					MAQUINAS[2]), };
	public static final int numTrabajos = TRABAJOS.length;

	public static final Libro LIBROS[] = {
			new Libro(1, "Rojo", 6, 25112021, 25112021, "Liso", TRABAJOS[1], CLIENTES[1]),
			new Libro(2, "Rojo", 10, 25112021, 25112021, "Liso", TRABAJOS[3], CLIENTES[2]),
			new Libro(3, "Rojo", 3, 25112021, 25112021, "Liso", TRABAJOS[4], CLIENTES[2]) };
	public static final int numLibros = LIBROS.length;

	public static final Poster POSTERS[] = {
			new Poster(1, 4.5, 6.8, 9, 25112021, 25112021, "Liso", TRABAJOS[5], CLIENTES[0]),
			new Poster(2, 10, 9.3, 3, 25112021, 25112021, "Liso", TRABAJOS[8], CLIENTES[2]),
			new Poster(3, 3.2, 4.7, 2, 25112021, 25112021, "Rugoso", TRABAJOS[8], CLIENTES[1]) };
	public static final int numPoster = POSTERS.length;

	public static final Rotulo ROTULOS[] = {
			new Rotulo(1, "LosFresnos", 25112021, 25112021, "Liso", TRABAJOS[2], CLIENTES[2]),
			new Rotulo(2, "ElCorteIngles", 25112021, 25112021, "Liso", TRABAJOS[6], CLIENTES[0]),
			new Rotulo(3, "AlCampo", 25112021, 25112021, "Liso", TRABAJOS[7], CLIENTES[1]) };
	public static final int numRotulos = ROTULOS.length;
}