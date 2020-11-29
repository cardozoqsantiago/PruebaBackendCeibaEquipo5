package com.ceiba.biblioteca.util;

/**
 * Clase encargada se reclutar todas las constantes
 * utilizadas en el proyecto
 *
 * @author Santiago Cardozo Q,
 * @author Nicolas Jaramillo S
 */
public class ConstantesUtils {


    /**
     * Constante para la base URL del BOOK
     */
    public static final String BASE_URL_BOOK = "/book";
    /**
     * Constante para la base URL del BOOK
     */
    public static final String BASE_URL_LOAN = "/loan";
    /**
     * Constante para la consulta de libros
     */
    public static final String GET_BOOKS = "/books";
    /**
     * constante para eliminar libros
     */
    public static final String DELETE_BOOKS = "/remove/{isbn}";
    
    public static final String CREATE_BOOKS = 	"/createBook";
    /**
     * Constante para el no registro de un usuario
     */
    public static final String NO_CREO_LIBRO = "No se creo el libro correctamente";
    /**
     * Se creo el usuario correctamente
     */
    public static final String SE_CREO_LIBRO = "Se creo el libro correctamente";
    /**
     * constante para eliminar libros
     */
    public static final String SE_BORRO_LIBRO = "El libro fue borrado";
    /**
     * constante para validar si un libro esta prestado
     */
    public static final String LIBRO_PRESTADO = "El libro esta prestado";
    /**
     * Constante para validar existencia del libro
     */
    public static final String LIBRO_NO_EXISTE = "El libro no existe";
    /**
     * Nombre del error tecnico
     */
    public static final String ERROR_TECNICO = "ERROR_TECNICO";
    /**
     * Nombre del error negocio
     */
    public static final String ERROR_NEGOCIO = "ERROR_NEGOCIO";
    /**
     * Nombre del error tecnico
     */
    public static final String EXITOSO = "EXITOSO";
    
    /**
     * Valor maximo de la suma de los digitos del isbn
     */
    public static final Long VALOR_MAXIMO_DIG_ISBN = 30l;
    
    /**
     * dias maximos de prestamo
     */
    public static final Long DIAS_MAXIMO_PRESTAMO = 15L;

}
