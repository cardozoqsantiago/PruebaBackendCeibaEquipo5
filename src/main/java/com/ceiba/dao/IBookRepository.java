package com.ceiba.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.model.BookEntity;

/**
 * Repositorio que soportara todas las querys realizadas
 * a la tabla Book
 * 
 * @author Santiago Cardozo Q
 *
 */
public interface IBookRepository extends JpaRepository<BookEntity, Long> {

}
