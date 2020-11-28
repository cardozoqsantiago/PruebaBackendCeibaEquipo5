package com.ceiba.service;


import com.ceiba.DTO.BookDTO;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Servicio que maneja toda la logica de negocio
 * necesaria para un libro
 *
 * @author Santiago Cardozo Q
 * @author Nicolas Jaramillo S
 */
@Component
public class BookService implements IBookService {


    @Override
    public BookDTO findBookByISBN(String ISBN) {
        return null;
    }

    @Override
    public List<BookDTO> findAllBooks(String ISBN) {
        return null;
    }
}
