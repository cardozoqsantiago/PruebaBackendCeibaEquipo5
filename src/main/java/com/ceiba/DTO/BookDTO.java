package com.ceiba.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@AllArgsConstructor
public class BookDTO {

    private Long id;
    private String isbn;
    private String name;
    private Long numberBooks;
    private Long numberLoans;
    private List<LoanDTO> Loan;

}
