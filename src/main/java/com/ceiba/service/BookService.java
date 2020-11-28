package com.ceiba.service;


import com.ceiba.DTO.BookDTO;
import com.ceiba.dao.IBookRepository;
import com.ceiba.model.BookEntity;
import com.ceiba.util.BibliotecaMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.transaction.SystemException;
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

    public BookService(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
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
            return BibliotecaMapper.toListBook(iBookRepository.findAll());
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
            BookEntity book = iBookRepository.findBook(isbn);
            if (!ObjectUtils.isEmpty(book)) {
                if (book.getNumberBooks() > 1) {
                    book.setNumberBooks(book.getNumberBooks() - 1);
                    iBookRepository.save(book);
                    response = "el libro fue borrado";
                } else if (book.getNumberBooks() == 1) {
                    iBookRepository.delete(book);
                    response = "el libro fue borrado";

                } else if (book.getNumberLoans() > 0 && book.getNumberBooks() == 1) {
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
