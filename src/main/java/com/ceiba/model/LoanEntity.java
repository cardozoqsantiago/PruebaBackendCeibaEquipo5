package com.ceiba.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Modelo para la tabla Loan
 * 
 * @author Santiago Cardozo Q
 *
 */
@Data
@Entity
@Table(name = "Loan")
public class LoanEntity {
	
	/**
	 * propiedad id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * propiedad idBook
	 */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_book" , referencedColumnName = "id")
	private BookEntity idBook;
	
	/**
	 * propiedad date
	 */
	@Column(name = "date" , nullable = false)
	private LocalDate date;
	
	/**
	 * propiedad returnDate
	 */
	@Column(name = "return_date", nullable = false)
	private LocalDate returnDate;
	
	/**
	 * propiedad isLoan
	 */
	@Column(name = "is_loan", nullable = false)
	private boolean isLoan;
	
	/**
	 * propiedad personName
	 */
	@Column(name = "person_name", nullable = false)
	private String personName;

}
