package com.ceiba.biblioteca.service;

import java.util.List;

import com.ceiba.biblioteca.dto.BookDTO;

/**
 * Interface para el negocio BookService
 *
 * @author Santiago Cardozo Q
 * @author Nicolas Jaramillo S
 */
public interface IBookService {

    List<BookDTO> findAllBooks();

	/**
	 * Metodo que permite crear un usuario
	 * 
	 * @param bookDTO
	 * @return
	 */
	void createBook(BookDTO bookDTO);

}
