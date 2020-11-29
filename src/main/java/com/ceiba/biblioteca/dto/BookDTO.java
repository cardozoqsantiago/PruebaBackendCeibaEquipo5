package com.ceiba.biblioteca.dto;

import lombok.Data;
import lombok.ToString;
import java.util.List;

/**
 * Pojo para la gestion de un libro
 *
 * @author Santiago Cardozo Q
 */
@Data
@ToString
public class BookDTO {
	
	/**
	 * propiedad id
	 */
	private Long id;
	/**
	 * propiedad isbn
	 */
    private String isbn;
    /**
	 * propiedad name
	 */
    private String name;
    /**
	 * propiedad numberBooks
	 */
    private Long numberBooks;
    /**
	 * propiedad numberLoans
	 */
    private Long numberLoans;
    /**
	 * propiedad Loan
	 */
    private List<LoanDTO> Loan;


}
