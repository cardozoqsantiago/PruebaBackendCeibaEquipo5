package com.ceiba.biblioteca.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.SystemException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ceiba.biblioteca.dao.IBookRepository;
import com.ceiba.biblioteca.dto.BookDTO;
import com.ceiba.biblioteca.model.BookEntity;
import com.ceiba.biblioteca.util.ConstantesUtils;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
	
	/**
	 * Constante para pruebas
	 */
	private String isbn = "A12345B";

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Mock
	IBookRepository iBookRepository;
	
	@InjectMocks
	BookService iBookService;
	
	/**
	 * Prueba para validar los filtros vacios
	 * @throws SystemException 
	 */
	@Test
	final void deleteBookTest() throws SystemException {
		BookEntity bookEntity = setData();
		when(iBookRepository.findByIsbn(isbn)).thenReturn(bookEntity);
		String esperado = iBookService.deleteBook(isbn);
		assertEquals(esperado, ConstantesUtils.SE_BORRO_LIBRO);
	}
	
	/**
	 * Prueba para validar el metodo de consultar
	 * todos los libros
	 * @throws SystemException
	 */
	@Test
	final void findAllBooks() throws SystemException {
		when(iBookRepository.findAll()).thenReturn(getList());
		List<BookDTO> esperado = iBookService.findAllBooks();
		assertEquals(getList().get(0).getIsbn(), esperado.get(0).getIsbn());
	}
	
	/**
	 * Setea datos a una entidad
	 * @return
	 */
	private BookEntity setData() {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setId(1L);
		bookEntity.setIsbn("A12345B");
		bookEntity.setName("Libro");
		bookEntity.setNumberBooks(1L);
		bookEntity.setNumberLoans(0L);
		return bookEntity;
	}
	
	/**
	 * Setea datos a una lista
	 * @return
	 */
	private List<BookEntity> getList() {
		List<BookEntity> listBooks = new ArrayList<>();
		BookEntity bookEntity = setData();
		listBooks.add(bookEntity);	
		return listBooks;
	}

}
