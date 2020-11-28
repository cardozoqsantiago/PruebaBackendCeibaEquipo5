package com.ceiba.service;

import com.ceiba.DTO.BookDTO;

import java.util.List;

/**
 * Interface para el negocio BookService
 *
 * @author Santiago Cardozo Q
 * @author Nicolas Jaramillo S
 */
public interface IBookService {

    List<BookDTO> findAllBooks();

}
