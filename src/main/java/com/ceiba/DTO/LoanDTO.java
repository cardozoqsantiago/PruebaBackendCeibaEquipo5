package com.ceiba.DTO;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
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
