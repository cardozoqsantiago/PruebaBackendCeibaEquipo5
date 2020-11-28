package com.ceiba.service;


import com.ceiba.DTO.BookDTO;
import com.ceiba.dao.IBookRepository;
import com.ceiba.model.BookEntity;
import com.ceiba.util.BibliotecaMapper;
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
    private IBookRepository iBookRepository;
    private BibliotecaMapper bibliotecaMapper;

    public BookService(IBookRepository iBookRepository, BibliotecaMapper bibliotecaMapper) {
        this.iBookRepository = iBookRepository;
        this.bibliotecaMapper = bibliotecaMapper;
    }

    /**
     * metodo que consulta todos los libros prestados y sin prestar
     *
     * @return lista de BookDTO
     */
    @Override
    public List<BookDTO> findAllBooks() {
        BookEntity tableBook = iBookRepository.findAllBooks();
        return null;
    }
}
