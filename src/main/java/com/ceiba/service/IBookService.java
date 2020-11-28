package com.ceiba.service;

import com.ceiba.DTO.BookDTO;

import java.util.List;

/**
 * Interface para el negocio BookService
 * 
 * @author Santiago Cardozo Q
 *
 */
public interface IBookService {

    BookDTO findBookByISBN (String ISBN);

    List<BookDTO> findAllBooks(String ISBN );

}
