package utils;

import entidades.*;

public class Datos {
    
    public static final Cliente CLIENTES[] = {
        new Cliente(1, "Juan", "Golondrina"),
        new Cliente(2, "Rufina", "Gonzalez"),
        new Cliente(3, "Jose", "Gonzalez")
    };
    public static final int numClientes = CLIENTES.length;
    
    
    public static final Departamento DEPARTAMENTOS[] = {
            new Departamento('A'),
            new Departamento('B'),
            new Departamento('C')
    };
    public static final int numDepartamento = DEPARTAMENTOS.length;
    
    
    public static final Lote LOTES[] = {
            new Lote(1, "Lote1", DEPARTAMENTOS['A']),
            new Lote(2, "Lote2", DEPARTAMENTOS['B']),
            new Lote(3, "Lote3", DEPARTAMENTOS['C'])
    };
    public static final int numLote = LOTES.length;
    
    
    public static final Operario OPERARIOS[] = {
        new Operario(1, "83492590M", "Benito", "Garcia", 682749158, "Gijon", DEPARTAMENTOS['A']),
        new Operario(2, "83497256J", "Juan", "Perez", 639674539, "Barcelona", DEPARTAMENTOS['A']),
        new Operario(3, "72912597P", "Jose", "Fernandez", 639284027, "Valladolid", DEPARTAMENTOS['B']),
        new Operario(4, "25840183M", "Sandra", "Martinez", 684038275, "Toledo", DEPARTAMENTOS['C']),
        new Operario(5, "72675927F", "Borja", "Rojo", 616803247, "Cordoba", DEPARTAMENTOS['C']),
        new Operario(6, "27492027D", "Andrea", "Rubia", 673402184, "Caceres", DEPARTAMENTOS['A']),
        new Operario(7, "19473502M", "Aitor", "Ali", 698723688, "Madrid", DEPARTAMENTOS['C']),
        new Operario(8, "32856382K", "Ruben", "Yamaoka", 638502850, "Murcia", DEPARTAMENTOS['B']),
        new Operario(9, "83620174H", "Ana", "Fernandez", 699472958, "Gijon", DEPARTAMENTOS['A'])
     };
    public static final int numOperarios = OPERARIOS.length;
    
    
    public static final OpImpresion OPSIMPRESION[] = {
            new OpImpresion(3, "72912597P", "JoseFernandez", 1),
            new OpImpresion(7, "19473502M", "AitorAli", 2),
            new OpImpresion(1, "83492590M", "BenitoGarcia", 3)
    };
    public static final int numOpImpresion = OPSIMPRESION.length;
    
    
    public static final OpMaquina OPSMAQUINA[] = {
            new OpMaquina(OPERARIOS[2], "83497256J", "JuanPerez"),
            new OpMaquina(OPERARIOS[8], "32856382K", "RubenYamaoka"),
            new OpMaquina(OPERARIOS[9], "83620174H", "AnaFernandez")
    };
    public static final int numOpMaquina = OPSMAQUINA.length;
    
    
    public static final Maquina MAQUINAS[] = {
            new Maquina(1, 25112021, "Sotano", LOTES[1]),
            new Maquina(2, 25112021, "Sotano", LOTES[1]),
            new Maquina(3, 25112021, "P1", LOTES[2]),
            new Maquina(4, 25112021, "P1", LOTES[2]),
            new Maquina(5, 25112021, "P2", LOTES[3]),
            new Maquina(6, 25112021, "P2", LOTES[3])
    };
    public static final int numMaquina = MAQUINAS.length;
    
    
    public static final LaboresMantenimiento LABORES[] = {
            new LaboresMantenimiento(1, 25112021, "Descripcion", MAQUINAS[1], OPSMAQUINA[2]),
            new LaboresMantenimiento(2, 25112021, "Descripcion", MAQUINAS[2], OPSMAQUINA[8]),
            new LaboresMantenimiento(3, 25112021, "Descripcion", MAQUINAS[3], OPSMAQUINA[9])
    };
    public static final int numLabor = LABORES.length;
    
    
    public static final OpCalidad OPSCALIDAD[] = {
            new OpCalidad(OPERARIOS[6], "83492590M", "BenitoGarcia"),
            new OpCalidad(OPERARIOS[4], "25840183M", "SandraMartinez"),
            new OpCalidad(OPERARIOS[5], "72675927F", "BorjaRojo")
    };
    public static final int numOpCalidad = OPSCALIDAD.length;
    
    
    public static final Prueba PRUEBAS[] = {
            new Prueba(1, OPSCALIDAD[4], 26112021, "Explicacion", "Resultado", MAQUINAS[1]),
            new Prueba(2, OPSCALIDAD[6], 26112021, "Explicacion", "Resultado", MAQUINAS[3]),
            new Prueba(3, OPSCALIDAD[5], 26112021, "Explicacion", "Resultado", MAQUINAS[4]),
            new Prueba(4, OPSCALIDAD[5], 26112021, "Explicacion", "Resultado", MAQUINAS[3]),
            new Prueba(5, OPSCALIDAD[4], 26112021, "Explicacion", "Resultado", MAQUINAS[3]),
            new Prueba(6, OPSCALIDAD[4], 26112021, "Explicacion", "Resultado", MAQUINAS[5]),
            new Prueba(7, OPSCALIDAD[6], 26112021, "Explicacion", "Resultado", MAQUINAS[4]),
            new Prueba(8, OPSCALIDAD[6], 26112021, "Explicacion", "Resultado", MAQUINAS[1]),
            new Prueba(9, OPSCALIDAD[6], 26112021, "Explicacion", "Resultado", MAQUINAS[1]),
            new Prueba(10, OPSCALIDAD[6], 26112021, "Explicacion", "Resultado", MAQUINAS[2]),
            new Prueba(11, OPSCALIDAD[5], 26112021, "Explicacion", "Resultado", MAQUINAS[6]),
            new Prueba(12, OPSCALIDAD[4], 26112021, "Explicacion", "Resultado", MAQUINAS[6]),
            new Prueba(13, OPSCALIDAD[5], 26112021, "Explicacion", "Resultado", MAQUINAS[6]),
            new Prueba(14, OPSCALIDAD[5], 26112021, "Explicacion", "Resultado", MAQUINAS[3]),
            new Prueba(15, OPSCALIDAD[4], 26112021, "Explicacion", "Resultado", MAQUINAS[1]),
            new Prueba(16, OPSCALIDAD[4], 26112021, "Explicacion", "Resultado", MAQUINAS[3]),
            new Prueba(17, OPSCALIDAD[6], 26112021, "Explicacion", "Resultado", MAQUINAS[4]),
            new Prueba(18, OPSCALIDAD[5], 26112021, "Explicacion", "Resultado", MAQUINAS[1]),
    };
    public static final int numPrueba = PRUEBAS.length;
    
    
    public static final ReglaCalidad REGLAS[] = {
            new ReglaCalidad("Regla1", 1, PRUEBAS[1], PRUEBAS[2], PRUEBAS[3], OPSCALIDAD[4]),
            new ReglaCalidad("Regla2", 2, PRUEBAS[4], PRUEBAS[5], PRUEBAS[6], OPSCALIDAD[6]),
            new ReglaCalidad("Regla3", 3, PRUEBAS[7], PRUEBAS[8], PRUEBAS[9], OPSCALIDAD[4]),
            new ReglaCalidad("Regla4", 4, PRUEBAS[10], PRUEBAS[11], PRUEBAS[12], OPSCALIDAD[5]),
            new ReglaCalidad("Regla3", 5, PRUEBAS[13], PRUEBAS[14], PRUEBAS[15], OPSCALIDAD[5]),
            new ReglaCalidad("Regla3", 6, PRUEBAS[16], PRUEBAS[17], PRUEBAS[18], OPSCALIDAD[6]),
    };
    public static final int numRegla = REGLAS.length;
    
    
    public static final PoliticaCalidad POLITICAS[] = {
            new PoliticaCalidad(1, "Numero1", 25112021, "Descripcion", "Resultado", OPSCALIDAD[6], REGLAS[1], REGLAS[2]),
            new PoliticaCalidad(2, "Numero2", 25112021, "Descripcion", "Resultado", OPSCALIDAD[4], REGLAS[3], REGLAS[4]),
            new PoliticaCalidad(3, "Numero3", 25112021, "Descripcion", "Resultado", OPSCALIDAD[5], REGLAS[5], REGLAS[6]),
    };
    public static final int numPolitica = POLITICAS.length;
    
    
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
//           new Libro(1, "Rojo", 6, 25112021, 25112021, "Liso", TRABAJOS[1], CLIENTES[1]),
//            new Trabajo(2, 25112021, 25112021, "Rugoso", CLIENTES[1], MAQUINAS[3]),
//           new Trabajo(3, 25112021, 25112021, "Liso", CLIENTES[3], MAQUINAS[3])
    };
    public static final int numLibros = LIBROS.length;
}