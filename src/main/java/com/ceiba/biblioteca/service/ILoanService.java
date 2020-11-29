package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.dto.LoanDTO;
import com.ceiba.biblioteca.dto.ResponseLoanDTO;

/**
 * Interface para el negocio LoanService
 * 
 * @author Santiago Cardozo Q
 *
 */
public interface ILoanService {

	/**
	 * Metodo que maneja toda la logica para
	 * la creacion de un prestamo
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	ResponseLoanDTO leanBook(LoanDTO request) throws Exception;

}
