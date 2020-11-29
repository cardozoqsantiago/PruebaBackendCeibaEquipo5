package com.ceiba.biblioteca.dto;

import com.ceiba.biblioteca.model.LoanEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Pojo para la gestion de la respuesta
 * de un prestamos
 *
 * @author Santiago Cardozo Q
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ResponseLoanDTO {
	/**
	 * propiedad mensajeRespuesta
	 */
	private String mensajeRespuesta;
	/**
	 * propiedad estadoProceso
	 */
	private boolean estadoProceso;
	/**
	 * propiedad loan
	 */
	private LoanEntity loan;

}
