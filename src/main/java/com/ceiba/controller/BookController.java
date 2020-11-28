package com.ceiba.controller;


import com.ceiba.DTO.BookDTO;
import com.ceiba.service.IBookService;
import com.ceiba.util.ConstantesUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
