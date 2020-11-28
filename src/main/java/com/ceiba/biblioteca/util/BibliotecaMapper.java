package com.ceiba.biblioteca.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.ceiba.biblioteca.dto.BookDTO;
import com.ceiba.biblioteca.dto.LoanDTO;
import com.ceiba.biblioteca.model.BookEntity;
import com.ceiba.biblioteca.model.LoanEntity;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.transaction.SystemException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de mapear entidades a Dtos y viceversa
 *
 * @author Santiago Cardozo Q
 */
@Component
public class BibliotecaMapper {

    /**
     * metodo que convierte lista de entidades book a lista de book DTO
     *
     * @param books
     * @return
     */
    public static List<BookDTO> toListBook(List<BookEntity> books) {
        List<BookDTO> responseList = new ArrayList<>();
        for (BookEntity book : books) {
            responseList.add(toBookDTO(book));
        }
        return responseList;
    }

    /**
     * Metodo que mapea un BookDTO a su respectiva entidad
     *
     * @param bookEntity
     * @return
     */
    public static BookDTO toBookDTO(BookEntity bookEntity) {
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<BookEntity, BookDTO> bookMap = new PropertyMap<BookEntity, BookDTO>() {
            @Override
            protected void configure() {
                //optional
            }
        };
        modelMapper.addMappings(bookMap);
        return modelMapper.map(bookEntity, BookDTO.class);
    }


    /**
     * Metodo que mapea una BookEntity a su respectivo DTO
     *
     * @param bookDTO
     * @return
     */
    public static BookEntity toBookEntity(BookDTO bookDTO) {
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<BookDTO, BookEntity> bookDTOMap = new PropertyMap<BookDTO, BookEntity>() {
            @Override
            protected void configure() {
            }
        };
        modelMapper.addMappings(bookDTOMap);
        return modelMapper.map(bookDTO, BookEntity.class);
    }


    public static List<LoanDTO> toListLoan(List<LoanEntity> loanEntities) throws SystemException {
        List<LoanDTO> response = new ArrayList<>();
        if (!ObjectUtils.isEmpty(loanEntities)) {
            for (LoanEntity loan : loanEntities) {
                response.add(toLoanDTO(loan));
            }
            return response;
        }
        throw new SystemException();
    }

    /**
     * Metodo que mapea un LoanDTO a su respectiva entidad
     *
     * @param loanEntity
     * @return
     */
    public static LoanDTO toLoanDTO(LoanEntity loanEntity) {
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<LoanEntity, LoanDTO> loanMap = new PropertyMap<LoanEntity, LoanDTO>() {
            @Override
            protected void configure() {
                //optional
            }
        };
        modelMapper.addMappings(loanMap);
        return modelMapper.map(loanEntity, LoanDTO.class);
    }

    /**
     * Metodo que mapea una LoanEntity a su respectivo DTO
     *
     * @param loanDTO
     * @return
     */
    public static LoanEntity toLoanEntity(LoanDTO loanDTO) {
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<LoanDTO, LoanEntity> loanDTOMap = new PropertyMap<LoanDTO, LoanEntity>() {
            @Override
            protected void configure() {
            }
        };
        modelMapper.addMappings(loanDTOMap);
        return modelMapper.map(loanDTO, LoanEntity.class);
    }

}
