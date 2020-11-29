package com.ceiba.biblioteca.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * Pojo para la gestion de un prestamo
 *
 * @author Santiago Cardozo Q
 */
@Data
@ToString
public class LoanDTO {
	
	/**
	 * propiedad id
	 */
    private Long id;
    /**
	 * propiedad idBook
	 */
    private BookDTO idBook;
    /**
	 * propiedad date
	 */
    private LocalDate date;
    /**
	 * propiedad returnDate
	 */
    private LocalDate returnDate;
    /**
	 * propiedad isLoan
	 */
    private boolean isLoan;
    /**
	 * propiedad personName
	 */
    private String personName;
    /**
	 * propiedad diasPrestamo
	 */
    private Long diasPrestamo;
      
}
