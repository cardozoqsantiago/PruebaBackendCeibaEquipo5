package com.ceiba.dao;

import com.ceiba.model.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio que soportara todas las querys realizadas
 * a la tabla Loan
 *
 * @author Santiago Cardozo Q
 */
public interface ILoanRepository extends JpaRepository<LoanEntity, Long> {
    @Query("select n from LoanEntity n where n.idBook = :idBook ")
    List<LoanEntity> findAllLoanByIdBook(Long idBook);
}
