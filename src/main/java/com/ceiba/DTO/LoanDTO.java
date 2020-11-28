package com.ceiba.DTO;

import com.ceiba.model.BookEntity;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class LoanDTO {
    private Long id;
    private BookEntity idBook;
    private LocalDate date;
    private LocalDate returnDate;
    private boolean isLoan;
    private String personName;
}
