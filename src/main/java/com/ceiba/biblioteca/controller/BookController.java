package com.ceiba.biblioteca.controller;


import com.ceiba.biblioteca.dto.BookDTO;
import com.ceiba.biblioteca.service.IBookService;
import com.ceiba.biblioteca.util.ConstantesUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import javax.transaction.SystemException;
import java.util.List;


/**
 * Controlador para la gestion de un
 * libro
 *
 * @author Santiago Cardozo Q
 * @author Nicolas Jaramillo S
 */
@RestController
@RequestMapping(ConstantesUtils.BASE_URL_BOOK)
public class BookController {
    private final IBookService iBookService;

    public BookController(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    /**
     * servicio que consulta todos los libros prestados y disponibles
     *
     * @return List BookDTO
     * @throws SystemException
     */
    @GetMapping(ConstantesUtils.GET_BOOKS)
    public ResponseEntity<List<BookDTO>> findAllBooks() throws SystemException {
        System.out.println("PruebaBackendCeibaEquipo5 :: BookController :: findAllBooks :: searching Book");
        return ResponseEntity.status(HttpStatus.OK).body(iBookService.findAllBooks());
    }
    
    /**
     * Metodo que permite crear un libro
     * 
     * @param bookDTO
     * @return
     */
    @PostMapping(ConstantesUtils.CREATE_BOOKS)
    public ResponseEntity<String> createBook(@RequestBody BookDTO bookDTO) {
    	try {
    		iBookService.createBook(bookDTO);	
		} catch (Exception e) {
			return new ResponseEntity<>(ConstantesUtils.ERROR_TECNICO + ": " +  ConstantesUtils.NO_CREO_LIBRO + " " +  e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(ConstantesUtils.EXITOSO + ": " +  ConstantesUtils.SE_CREO_LIBRO, HttpStatus.OK);
    }
    
    /**
     * servicio que elimina los libros
     *
     * @param isbn
     * @return
     * @throws SystemException
     */
    @DeleteMapping(ConstantesUtils.DELETE_BOOKS)
    public ResponseEntity<String> deleteBooks(@PathVariable("isbn") String isbn) throws SystemException {
        System.out.println("PruebaBackendCeibaEquipo5 :: BookController :: deleteBooks :: searching Book");
        return ResponseEntity.status(HttpStatus.OK).body(iBookService.deleteBook(isbn));
    }
}
