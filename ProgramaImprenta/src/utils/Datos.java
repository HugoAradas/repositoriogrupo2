package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entidades.*;

public class Datos {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
    public static final Cliente CLIENTES[] = {
        new Cliente(1, "Juan", "Perez")
    };
    public static final int numClientes = CLIENTES.length;
    
    
    public static final Operario OPERARIOS[] = {
        new Operario(1, "83492590M", "Benito", "Garcia", 639674539, "Gijon")
     };
    public static final int numOperarios = OPERARIOS.length;
}