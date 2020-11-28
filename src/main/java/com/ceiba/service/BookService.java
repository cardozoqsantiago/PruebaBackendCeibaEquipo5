package com.ceiba.service;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ceiba.biblioteca.dao.IBookRepository;
import com.ceiba.biblioteca.dao.ILoanRepository;
import com.ceiba.biblioteca.dto.BookDTO;
import com.ceiba.biblioteca.model.BookEntity;
import com.ceiba.biblioteca.service.IBookService;
import com.ceiba.biblioteca.util.BibliotecaMapper;

import javax.transaction.SystemException;
import java.util.ArrayList;
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
    private ILoanRepository iLoanRepository;

    public BookService(IBookRepository iBookRepository, ILoanRepository iLoanRepository) {
        this.iBookRepository = iBookRepository;
        this.iLoanRepository = iLoanRepository;
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
                    response = "el libro fue borrado";
                } else if (book.getNumberBooks() == 1) {
                    iBookRepository.delete(book);
                    response = "el libro fue borrado";

                } else if (book.getNumberLoans() > 0 && book.getNumberBooks() == 0) {
                    response = "el libro esta prestado";

                }
                return response;
            }
            return "el libro no existe";
        } catch (Exception e) {
            throw new SystemException();
        }
    }


    /**
     * Metodo que permite crear un usuario
     *
     * @param bookDTO
     * @return
     */
    public void createBook(BookDTO bookDTO) {
        iBookRepository.save(BibliotecaMapper.toBookEntity(bookDTO));
    }


}
