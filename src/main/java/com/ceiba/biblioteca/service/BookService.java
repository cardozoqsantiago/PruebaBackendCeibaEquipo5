package com.ceiba.biblioteca.service;


import com.ceiba.biblioteca.dao.IBookRepository;
import com.ceiba.biblioteca.dao.ILoanRepository;
import com.ceiba.biblioteca.dto.BookDTO;
import com.ceiba.biblioteca.model.BookEntity;
import com.ceiba.biblioteca.util.BibliotecaMapper;
import com.ceiba.biblioteca.util.ConstantesUtils;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.SystemException;


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
    
	private ILoanRepository iLoanRepository;

    public BookService(IBookRepository iBookRepository, ILoanRepository iLoanRepository) {
        this.iBookRepository = iBookRepository;
        this.iLoanRepository = iLoanRepository;
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
    
    /**
     * eliminacion de los libros
     *
     * @param isbn
     * @return estado de eliminacion
     * @throws SystemException
     */
	@Override
	public String deleteBook(String isbn) throws SystemException {
		try {
			String response = null;
			BookEntity book = iBookRepository.findByIsbn(isbn);
			if (!ObjectUtils.isEmpty(book)) {
				if (book.getNumberBooks() > 1) {
					book.setNumberBooks(book.getNumberBooks() - 1);
					iBookRepository.save(book);
					response = ConstantesUtils.SE_BORRO_LIBRO;
				} else if (book.getNumberBooks() == 1) {
					iBookRepository.delete(book);
					response = ConstantesUtils.SE_BORRO_LIBRO;

				} else if (book.getNumberLoans() > 0 && book.getNumberBooks() == 0) {
					response = ConstantesUtils.LIBRO_PRESTADO;

				}
				return response;
			}
			return ConstantesUtils.LIBRO_NO_EXISTE;
		} catch (Exception e) {
			throw new SystemException();
		}
	}
	
	/**
	 * metodo que consulta todos los libros prestados y sin prestar
	 *
	 * @return list BookDTO
	 * @throws SystemException
	 */
	@Override
	public List<BookDTO> findAllBooks() throws SystemException {
		try {
			List<BookDTO> listBooks = BibliotecaMapper.toListBook(iBookRepository.findAll());
			List<BookDTO> responseList = new ArrayList<>();
			for (BookDTO book : listBooks) {
				if (book.getNumberLoans() > 0) {
					book.setLoan(BibliotecaMapper.toListLoan(iLoanRepository.findAllLoanByIdBook(book.getId())));
					responseList.add(book);
				} else {
					responseList.add(book);
				}
			}
			return responseList;
		} catch (Exception e) {
			throw new SystemException();
		}
	}

}
