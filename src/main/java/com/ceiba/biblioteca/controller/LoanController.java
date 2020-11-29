package com.ceiba.biblioteca.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.dto.LoanDTO;
import com.ceiba.biblioteca.dto.ResponseLoanDTO;
import com.ceiba.biblioteca.model.BookEntity;
import com.ceiba.biblioteca.model.LoanEntity;
import com.ceiba.biblioteca.service.LoanService;
import com.ceiba.biblioteca.util.ConstantesUtils;

/**
 * Controlador para la gestion de un
 * prestamo
 * 
 * @author Santiago Cardozo Q
 * @author Nicolas Jaramillo S
 *
 */

@RestController
@RequestMapping(ConstantesUtils.BASE_URL_LOAN)
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class LoanController {
	@Autowired 
	LoanService loanService;
	
	@PostMapping("/generarprestamo")
	public ResponseEntity<ResponseLoanDTO> leanBook(@RequestBody LoanDTO request) {
	    try {
	    	ResponseLoanDTO response = loanService.leanBook(request);
	       // return new ResponseEntity<>(loan ,HttpStatus.OK);
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	    } catch (Exception e) {
	    	System.out.println("Ocurio un error al hacer el prestamo. "+ e.toString());
	    	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      
	    }
	}

}
