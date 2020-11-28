package com.ceiba.controller;

import com.ceiba.util.ConstantesUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
