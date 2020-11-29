package com.ceiba.biblioteca.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.biblioteca.dao.IBookRepository;
import com.ceiba.biblioteca.dao.ILoanRepository;
import com.ceiba.biblioteca.dto.LoanDTO;
import com.ceiba.biblioteca.dto.ResponseLoanDTO;
import com.ceiba.biblioteca.model.BookEntity;
import com.ceiba.biblioteca.model.LoanEntity;
import com.ceiba.biblioteca.util.ConstantesUtils;

/**
 * Servicio que maneja toda la logica de negocio necesaria para un prestamo
 * 
 * @author Santiago Cardozo Q
 *
 */
@Service
public class LoanService implements ILoanService {

	/**
	 * Inyeccion del repositorio IBookRepository a traves
	 * del atributo iBookRepository
	 */
	@Autowired
	IBookRepository iBookRepository;

	/**
	 * Inyeccion del repositorio ILoanRepository a traves
	 * del atributo iLoanRepository
	 */
	@Autowired
	ILoanRepository iLoanRepository;

	/**
	 * Metodo que maneja toda la logica para la creacion de un prestamo
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public ResponseLoanDTO leanBook(LoanDTO request) throws Exception {
		ResponseLoanDTO response = new ResponseLoanDTO();
		response.setEstadoProceso(true);
		try {
			String isbnLocal = "";
			BookEntity book = iBookRepository.findByIsbn(request.getIdBook().getIsbn());
			// validar que haya existencias
			if (book == null) {
				response.setMensajeRespuesta("El libro a prestar no existe.");
				response.setEstadoProceso(false);
				throw new Exception("El libro a prestar no existe.");
			} else
				isbnLocal = book.getIsbn();
			// validar que sea palindromo
			if (validarPalindromo(isbnLocal)) {
				response.setMensajeRespuesta("Los libros palíndromos solo se pueden utilizar en la biblioteca");
				response.setEstadoProceso(false);
				throw new Exception("Los libros palíndromos solo se pueden utilizar en la biblioteca");
			}
			// validar que haya existencias
			if (book.getNumberBooks() == 0) {
				response.setMensajeRespuesta("No existen libros disponibles.");
				response.setEstadoProceso(false);
				throw new Exception("No existen libros disponibles.");
			}
			// validar cantidad de digitos en el isbn
			if (validarDigitosIsbn(isbnLocal)) {
				if (request.getDiasPrestamo() > ConstantesUtils.DIAS_MAXIMO_PRESTAMO) {
					request.setDiasPrestamo(ConstantesUtils.DIAS_MAXIMO_PRESTAMO);
				}
			}
			// Obtener la fecha del prestamo
			Date fechaPrestamo = new Date();
			fechaPrestamo = obtenerFechaFinal(request.getDiasPrestamo(),
					sumarRestarDiasFecha(convertToDateViaSqlDate(request.getDate()), -1l));
			// BookEntity book = new BookEntity();
			book.setNumberBooks(book.getNumberBooks() - 1);
			book.setNumberLoans(book.getNumberLoans() + 1);
			LoanEntity loan = new LoanEntity();
			loan.setIdBook(book);
			loan.setLoan(true);
			loan.setPersonName(request.getPersonName());
			loan.setDate(request.getDate());
			loan.setReturnDate(convertToLocalDateViaSqlDate(fechaPrestamo));
			response.setLoan(iLoanRepository.save(loan));
			response.setMensajeRespuesta("Prestamo realizado con éxito.");
		} catch (Exception e) {
			System.out.println("Ocurio un error al hacer el prestamo.");
		}
		return response;
	}

	/*
	 * Metodo que convierte un Date a un LocalDate Return: LocalDate
	 */
	private LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
		return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}

	/*
	 * Metodo que convierte un LocalDate a un Date Return: Date
	 */
	private Date convertToDateViaSqlDate(LocalDate dateToConvert) {
		return java.sql.Date.valueOf(dateToConvert);
	}

	/*
	 * Metodo que recibe una fecha y los dias a aumentar, omitiendo los domingos
	 * Return: Date
	 */
	private Date obtenerFechaFinal(Long diasPrestamo, Date fechaInicial) throws java.text.ParseException {
		Long numeroDomingos = 0l;
		for (int i = 0; i < diasPrestamo; i++) {
			fechaInicial = sumarRestarDiasFecha(fechaInicial, 1l);
			if (verificarFechaDomingo(fechaInicial)) {
				numeroDomingos++;
			}
		}
		if (numeroDomingos > 0) {
			fechaInicial = obtenerFechaFinal(numeroDomingos, fechaInicial);
		}
		return fechaInicial;
	}

	/*
	 * Metodo que suma dias a una fecha Return: Date
	 */
	private Date sumarRestarDiasFecha(Date fecha, Long dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias.intValue()); // numero de días a añadir, o restar en caso de días<0
		return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	}

	/*
	 * metodo que verifica si un codigo es palindromo Return: Date
	 */
	private boolean validarPalindromo(String isbn) {
		int inc = 0;
		int des = isbn.length() - 1;
		boolean bError = false;

		while ((inc < des) && (!bError)) {
			if (isbn.charAt(inc) == isbn.charAt(des)) {
				inc++;
				des--;
			} else {
				bError = true;
			}
		}
		return !bError;
	}

	/*
	 * metodo que valida si un sbn suma mas de 30 Return: Date
	 */
	private boolean validarDigitosIsbn(String isbn) {
		Long suma = 0l;
		String caracter = "";
		for (int i = 0; i < isbn.length() - 1; i++) {
			caracter = "" + isbn.charAt(i);
			try {
				suma = suma + Long.valueOf(caracter);
			} catch (Exception e) {
			}
		}
		if (suma > ConstantesUtils.VALOR_MAXIMO_DIG_ISBN) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * metodo que si una fecha es domingo Return: Date
	 */
	private boolean verificarFechaDomingo(Date fechaActual) throws java.text.ParseException {
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaActual);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		if (diaSemana == 1) {
			return true;
		} else {
			return false;
		}
	}

}
