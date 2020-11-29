package com.ceiba.biblioteca.service;

import javax.transaction.SystemException;
import java.util.List;

import com.ceiba.biblioteca.dto.BookDTO;

/**
 * Interface para el negocio BookService
 *
 * @author Santiago Cardozo Q
 * @author Nicolas Jaramillo S
 */
public interface IBookService {

	/**
	 * metodo que consulta todos los libros prestados y sin prestar
	 *
	 * @return list BookDTO
	 * @throws SystemException
	 */
    List<BookDTO> findAllBooks() throws SystemException;

    /**
	 * metodo que consulta todos los libros prestados y sin prestar
	 *
	 * @return list BookDTO
	 * @throws SystemException
	 */
    String deleteBook(String isbn) throws SystemException;

	/**
	 * Metodo que permite crear un usuario
	 * 
	 * @param bookDTO
	 * @return
	 */
	void createBook(BookDTO bookDTO);

}
