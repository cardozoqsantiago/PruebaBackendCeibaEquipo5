package com.ceiba.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.model.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repositorio que soportara todas las querys realizadas
 * a la tabla Book
 * 
 * @author Santiago Cardozo Q
 *
 */
public interface IBookRepository extends JpaRepository<BookEntity, Long> {

    @Query("select n from BookEntity n where n.isbn = :isbn ")
    BookEntity findBook(String isbn);

}
