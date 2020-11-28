package com.ceiba.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Pojo para la gestion de un libro
 *
 * @author Santiago Cardozo Q
 */

@Data
@ToString
@Builder
@AllArgsConstructor
public class BookDTO {
	
    private Long id;
    private String name;
    private Long numberBooks;
    private Long numberLoans;
    private String isbn;

}
