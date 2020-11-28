package com.ceiba.biblioteca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.biblioteca.model.LoanEntity;

/**
 * Repositorio que soportara todas las querys realizadas
 * a la tabla Loan
 * 
 * @author Santiago Cardozo Q
 *
 */
public interface ILoanRepository extends JpaRepository<LoanEntity, Long> {

}
