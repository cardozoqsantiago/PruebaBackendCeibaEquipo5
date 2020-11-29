package com.ceiba.biblioteca.dto;

import com.ceiba.biblioteca.model.LoanEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ResponseLoanDTO {
	
	private String mensajeRespuesta;
	
	private boolean estadoProceso;

	private LoanEntity loan;

}
