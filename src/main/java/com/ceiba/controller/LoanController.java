package com.ceiba.controller;

import com.ceiba.DTO.LoanDTO;
import com.ceiba.model.LoanEntity;
import com.ceiba.service.LoanService;
import com.ceiba.util.ConstantesUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	LoanService loanService;
	
	@PostMapping("/generarprestamo")
	public ResponseEntity<LoanEntity> leanBook(@RequestBody LoanDTO request) {
	    try {
	        return new ResponseEntity<>( loanService.leanBook(request),HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
