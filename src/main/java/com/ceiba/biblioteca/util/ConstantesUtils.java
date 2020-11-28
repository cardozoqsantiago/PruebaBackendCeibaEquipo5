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
    public static final String DELETE_BOOKS = "/book/remove/{isbn}";
    /**
     * Constante para el no registro de un usuario
     */
    public static final String NO_CREO_LIBRO = "No se creo el libro correctamente";
    /**
     * Se creo el usuario correctamente
     */
    public static final String SE_CREO_LIBRO = "Se creo el libro correctamente";
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

}
