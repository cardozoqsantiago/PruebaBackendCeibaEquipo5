package com.ceiba.DTO;


import lombok.*;

/**
 * Pojo para la gestion de un libro
 *
 * @author Santiago Cardozo Q
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookDTO {
    private Long id;
    private String name;
    private Long numberBooks;
    private Long numberLoans;
}
