package com.ceiba.biblioteca.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
public class LoanDTO {
    private Long id;
    private BookDTO idBook;
    private LocalDate date;
    private LocalDate returnDate;
    private boolean isLoan;
    private String personName;
    private Long diasPrestamo;
    
    
}
