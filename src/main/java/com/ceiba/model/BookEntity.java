package com.ceiba.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modelo para la tabla Book
 * 
 * @author Santiago Cardozo Q
 *
 */
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
	 * propiedad id
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
