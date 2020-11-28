package com.ceiba.biblioteca.util;

import lombok.Data;

/**
 * Clase encargada de manejar las excepciones
 * 
 * @author Santiago Cardozo Q
 *
 */
@Data
public class BibliotecaException extends Exception  {
	
	/**
	 * Serial del objeto
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo para tipo error
	 */
	private String tipoError;

	/**
	 * Constructor con las propiedades
	 * 
	 * @param tipoError el valor de la propiedad
	 */
	public BibliotecaException(String tipoError, String mensaje) {
		super(mensaje);
		this.tipoError = tipoError;
	}
}
