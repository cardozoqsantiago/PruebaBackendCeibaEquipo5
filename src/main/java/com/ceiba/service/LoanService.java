package com.ceiba.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ceiba.DTO.DtoRequestLean;
import com.ceiba.model.LoanEntity;
import com.ceiba.util.ConstantesUtils;
import com.sun.el.parser.ParseException;

/**
 * Servicio que maneja toda la logica de negocio 
 * necesaria para un prestamo
 * 
 * @author Santiago Cardozo Q
 *
 */
@Service
public class LoanService implements ILoanService {
	
	
	public LoanEntity leanBook (DtoRequestLean request) throws Exception {
		//validar que sea palindromo
		if (validarPalindromo(request.getIsbn()))
			throw new Exception ("Los libros palíndromos solo se pueden utilizar en la biblioteca");
	
		//validar cantidad de digitos en el isbn
		if (validarDigitosIsbn(request.getIsbn())) {
			if (request.getDiasPrestamo() > ConstantesUtils.VALOR_MAXIMO_DIG_ISBN) {
				request.setDiasPrestamo(ConstantesUtils.VALOR_MAXIMO_DIG_ISBN);
			}
		}
		Date fechaPrestamo = new Date();
		int numeroDomingos=0;
		for(int i=0;i<request.getDiasPrestamo();i++) {
			fechaPrestamo = sumarRestarDiasFecha(fechaPrestamo,request.getDiasPrestamo());
		}
		return null;
	
	}
	
	public Date sumarRestarDiasFecha(Date fecha, Long dias){
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fecha); // Configuramos la fecha que se recibe
	    calendar.add(Calendar.DAY_OF_YEAR, dias.intValue());  // numero de días a añadir, o restar en caso de días<0
	    return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	}

	
	private boolean validarPalindromo(String isbn) {
		int inc = 0;
		int des = isbn.length()-1;
		String result="";
		boolean bError = false;
		  
		while ((inc<des) && (!bError)){
			if (isbn.charAt(inc)==isbn.charAt(des)){				
				inc++;
				des--;
			} else {
				bError = true;
			}
		}
		  
		if (!bError)
			result = isbn + " es un PALINDROMO";
		else
			result = isbn + " NO es un palindromo";
		  
		return bError;
	}
	
	private boolean validarDigitosIsbn(String isbn) {
		Long suma = 0l;
		String caracter="";
		for (int i=0; i<isbn.length()-1;i++) {
			caracter = ""+isbn.charAt(i);
			try {
				suma = suma + Long.valueOf(caracter);
			}catch(Exception e)
			{	
			}
		}
		if(suma > ConstantesUtils.VALOR_MAXIMO_DIG_ISBN) {
			return true;
		}else{
			return false;
		}
	}
	
	
	private boolean verificarFechaDomingo(Date fechaActual) throws java.text.ParseException {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date fechaActual = null;
//		try {
//			fechaActual = df.parse(fecha);
//		} catch (Exception e) {
//			System.err.println("No se ha podido parsear la fecha.");
//			e.printStackTrace();
//		}
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaActual);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		if (diaSemana == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	

}
