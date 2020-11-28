package com.ceiba.biblioteca.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ceiba.biblioteca.model.BookEntity;

/**
 * Repositorio que soportara todas las querys realizadas
 * a la tabla Book
 * 
 * @author Santiago Cardozo Q
 *
 */
public interface IBookRepository extends JpaRepository<BookEntity, Long> {

    @Query("select n from BookEntity n")
    BookEntity findAllBooks();
    
    BookEntity findByIsbn(String isnb);

}
