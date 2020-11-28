package com.ceiba.controller;


import com.ceiba.DTO.BookDTO;
import com.ceiba.service.IBookService;
import com.ceiba.util.ConstantesUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(ConstantesUtils.GET_BOOKS)
    public ResponseEntity<List<BookDTO>> findAllBooks() {
        System.out.println("PruebaBackendCeibaEquipo5 :: BookController :: findAllBooks :: searching Book");
        return ResponseEntity.status(HttpStatus.OK).body(iBookService.findAllBooks());
    }

}
