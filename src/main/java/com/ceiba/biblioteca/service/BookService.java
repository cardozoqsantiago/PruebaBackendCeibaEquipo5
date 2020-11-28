package com.ceiba.biblioteca.service;


import com.ceiba.biblioteca.dao.IBookRepository;
import com.ceiba.biblioteca.dto.BookDTO;
import com.ceiba.biblioteca.model.BookEntity;
import com.ceiba.biblioteca.util.BibliotecaMapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


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

    public BookService(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
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
    
    /**
     * Metodo que permite crear un libro
     * 
     * @param bookDTO
     * @return
     */
    @Override
    public void createBook(BookDTO bookDTO) {
    	BookEntity bookEntity = validateExistenceBook(bookDTO.getIsbn());
    	if(bookEntity.getId() == null) {
    		bookDTO.setNumberBooks(1L);
    		bookDTO.setNumberLoans(0L);
    		iBookRepository.save(BibliotecaMapper.toBookEntity(bookDTO));
    	}
    	else {
    		bookEntity.setNumberBooks(bookEntity.getNumberBooks() + 1);
    		iBookRepository.save(bookEntity);
    	}	
    }
    
    /**
     * Metodo que indica sin un libro ya existe
     * 
     * @param isbn
     * @return true si existe, false de lo contrario
     */
    private BookEntity validateExistenceBook(String isbn) {
    	if(isbn != null) {
    		BookEntity bookEntity = iBookRepository.findByIsbn(isbn);
    		if (bookEntity != null) {
				return bookEntity;
			} else {
				return new BookEntity();
			}
    	}
    	return new BookEntity();
    }
    
    
}
