package com.ceiba.biblioteca.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ceiba.biblioteca.model.BookEntity;

/**
 * Repositorio que soportara todas las querys realizadas
 * a la tabla Book
 * 
 * @author Santiago Cardozo Q
 *
 */
public interface IBookRepository extends JpaRepository<BookEntity, Long> {

 
	/**
	 * Consulta los libros por Isbn
	 * 
	 * @param isnb
	 * @return
	 */
    BookEntity findByIsbn(String isnb);
    
}
