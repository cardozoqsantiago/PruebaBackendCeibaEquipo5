package com.ceiba.biblioteca.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Modelo para la tabla Book
 * 
 * @author Santiago Cardozo Q
 *
 */
@Data
@Entity
@Table(name = "Book")
public class BookEntity {
	
	/**
	 * propiedad id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * Propiedad isbn
	 */
	@Column(name = "isbn", nullable = false)
	private String isbn;
	
	/**
	 * propiedad name
	 */
	@Column(name = "name", nullable = false)
	private String name;
	
	/**
	 * propiedad numberBooks
	 */
	@Column(name = "numer_books", nullable = false)
	private Long numberBooks;
	
	/**
	 * propiedad numberLoans
	 */
	@Column(name = "number_loans", nullable = true)
	private Long numberLoans;

	
	

}
