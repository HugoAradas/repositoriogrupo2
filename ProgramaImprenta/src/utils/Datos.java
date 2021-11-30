package utils;

import entidades.*;

public class Datos {
    
    public static final Cliente CLIENTES[] = {
        new Cliente(1, "Juan", "Golondrina"),
        new Cliente(2, "Rufina", "Gonzalez"),
        new Cliente(3, "Jose", "Gonzalez")
    };
    public static final int numClientes = CLIENTES.length;
    
    
    public static final Operario OPERARIOS[] = {
        new Operario(1, "83492590M", "Benito", "Garcia", 682749158, "Gijon", 'A'),
        new Operario(2, "83497256J", "Juan", "Perez", 639674539, "Barcelona", 'A'),
        new Operario(3, "72912597P", "Jose", "Fernandez", 639284027, "Valladolid", 'B'),
        new Operario(4, "25840183M", "Sandra", "Martinez", 684038275, "Toledo", 'C'),
        new Operario(5, "72675927F", "Borja", "Rojo", 616803247, "Cordoba", 'C'),
        new Operario(6, "27492027D", "Andrea", "Rubia", 673402184, "Caceres", 'A'),
        new Operario(7, "19473502M", "Aitor", "Ali", 698723688, "Madrid", 'C'),
        new Operario(8, "32856382K", "Ruben", "Yamaoka", 638502850, "Murcia", 'B'),
        new Operario(9, "83620174H", "Ana", "Fernandez", 699472958, "Gijon", 'A')
     };
    public static final int numOperarios = OPERARIOS.length;
    
    
    public static final Departamento DEPARTAMENTOS[] = {
            new Departamento('A'),
            new Departamento('B'),
            new Departamento('C')
    };
    public static final int numDepartamento = DEPARTAMENTOS.length;
    
    
    public static final OpImpresion OPSIMPRESION[] = {
            new OpImpresion(3, "72912597P", "JoseFernandez", 1),
            new OpImpresion(7, "19473502M", "AitorAli", 2),
            new OpImpresion(1, "83492590M", "BenitoGarcia", 3)
    };
    public static final int numOpImpresion = OPSIMPRESION.length;
    
    
    public static final OpMaquina OPSMAQUINA[] = {
            new OpMaquina(2, "83497256J", "JuanPerez", 1),
            new OpMaquina(8, "32856382K", "RubenYamaoka", 2),
            new OpMaquina(9, "83620174H", "AnaFernandez", 3)
    };
    public static final int numOpMaquina = OPSMAQUINA.length;
    
    
    public static final Maquina MAQUINAS[] = {
            new Maquina(1, 25112021, "Sotano"),
            new Maquina(2, 25112021, "P1"),
            new Maquina(3, 25112021, "P2")
    };
    public static final int numMaquina = MAQUINAS.length;
    
    
    public static final LaboresMantenimiento LABORES[] = {
            new LaboresMantenimiento(1, 25112021, "Descripcion", 1),
            new LaboresMantenimiento(2, 25112021, "Descripcion", 3),
            new LaboresMantenimiento(3, 25112021, "Descripcion", 2),
            new LaboresMantenimiento(4, 25112021, "Descripcion", 3),
            new LaboresMantenimiento(5, 25112021, "Descripcion", 1),
            new LaboresMantenimiento(6, 25112021, "Descripcion", 2)
    };
    public static final int numLabor = LABORES.length;
    
    
    public static final OpCalidad OPSCALIDAD[] = {
            new OpCalidad(1, "83492590M", "BenitoGarcia"),
            new OpCalidad(4, "25840183M", "SandraMartinez"),
            new OpCalidad(5, "72675927F", "BorjaRojo")
    };
    public static final int numOpCalidad = OPSCALIDAD.length;
    
    
    public static final PoliticaCalidad POLITICAS[] = {
            new PoliticaCalidad(1, "Numero1", 25112021, "Descripcion", "Resultado", 1, 1, 2),
            new PoliticaCalidad(2, "Numero2", 25112021, "Descripcion", "Resultado", 4, 3, 4),
            new PoliticaCalidad(3, "Numero3", 25112021, "Descripcion", "Resultado", 5, 5, 6),
    };
    public static final int numPolitica = POLITICAS.length;
    
    
    public static final ReglaCalidad REGLAS[] = {
            new ReglaCalidad("Regla1", 1, 1, 2, 3),
            new ReglaCalidad("Regla2", 2, 4, 5, 6),
            new ReglaCalidad("Regla3", 3, 7, 8, 9),
            new ReglaCalidad("Regla4", 4, 10, 11, 12),
            new ReglaCalidad("Regla3", 5, 13, 14, 15),
            new ReglaCalidad("Regla3", 6, 16, 17, 18),
    };
    public static final int numRegla = REGLAS.length;
    
    
    public static final Prueba PRUEBAS[] = {
            new Prueba(26112021, "Explicacion", "Resultado", 1, 4),
            new Prueba(26112021, "Explicacion", "Resultado", 2, 1),
            new Prueba(26112021, "Explicacion", "Resultado", 3, 5),
            new Prueba(26112021, "Explicacion", "Resultado", 4, 4),
            new Prueba(26112021, "Explicacion", "Resultado", 5, 1),
            new Prueba(26112021, "Explicacion", "Resultado", 6, 5),
            new Prueba(26112021, "Explicacion", "Resultado", 7, 4),
            new Prueba(26112021, "Explicacion", "Resultado", 8, 1),
            new Prueba(26112021, "Explicacion", "Resultado", 9, 5),
            new Prueba(26112021, "Explicacion", "Resultado", 10, 4),
            new Prueba(26112021, "Explicacion", "Resultado", 11, 1),
            new Prueba(26112021, "Explicacion", "Resultado", 12, 5),
            new Prueba(26112021, "Explicacion", "Resultado", 13, 4),
            new Prueba(26112021, "Explicacion", "Resultado", 14, 1),
            new Prueba(26112021, "Explicacion", "Resultado", 15, 5),
            new Prueba(26112021, "Explicacion", "Resultado", 16, 4),
            new Prueba(26112021, "Explicacion", "Resultado", 17, 1),
            new Prueba(26112021, "Explicacion", "Resultado", 18, 5),
    };
    public static final int numPrueba = PRUEBAS.length;
    
    
    public static final Trabajo TRABAJOS[] = {
            new Trabajo(1, 25112021, 25112021, "Liso", CLIENTES[1], MAQUINAS[1]),
            new Trabajo(2, 25112021, 25112021, "Rugoso", CLIENTES[1], MAQUINAS[3]),
            new Trabajo(3, 25112021, 25112021, "Liso", CLIENTES[3], MAQUINAS[3]),
            new Trabajo(4, 25112021, 25112021, "Rugoso", CLIENTES[1], MAQUINAS[1]),
            new Trabajo(5, 25112021, 25112021, "Liso", CLIENTES[2], MAQUINAS[3]),
            new Trabajo(6, 25112021, 25112021, "Liso", CLIENTES[3], MAQUINAS[2]),
            new Trabajo(1, 25112021, 25112021, "Liso", CLIENTES[3], MAQUINAS[1]),
            new Trabajo(2, 25112021, 25112021, "Rugoso", CLIENTES[2], MAQUINAS[1]),
            new Trabajo(3, 25112021, 25112021, "Liso", CLIENTES[3], MAQUINAS[2]),
    };
    public static final int numTrabajos = TRABAJOS.length;
    
    public static final Libro LIBROS[] = {
//            new Libro(1, "Rojo", 6, TRABAJOS[1], 25112021, 25112021, 25112021, "Liso"),
//            new Trabajo(2, 25112021, 25112021, "Rugoso", CLIENTES[1], MAQUINAS[3]),
//           new Trabajo(3, 25112021, 25112021, "Liso", CLIENTES[3], MAQUINAS[3])
    };
    public static final int numLibros = LIBROS.length;
}