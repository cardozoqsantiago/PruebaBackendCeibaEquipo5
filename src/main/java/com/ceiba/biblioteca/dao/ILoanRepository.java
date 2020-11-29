package com.ceiba.biblioteca.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.biblioteca.model.LoanEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Repositorio que soportara todas las querys realizadas
 * a la tabla Loan
 *
 * @author Santiago Cardozo Q
 */
public interface ILoanRepository extends JpaRepository<LoanEntity, Long> {
	
	/**
	 * Consulta los registros de un prestamo 
	 * segun el id del libro
	 * 
	 * @param idBook
	 * @return
	 */
    @Query("select n from LoanEntity n where n.idBook = :idBook ")
    List<LoanEntity> findAllLoanByIdBook(Long idBook);
}
