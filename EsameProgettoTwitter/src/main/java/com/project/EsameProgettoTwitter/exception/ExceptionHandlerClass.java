/**
 * 
 */
package com.project.EsameProgettoTwitter.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Federico Paolucci
 *
 */
public class ExceptionHandlerClass {
	
	@ExceptionHandler( value = {InternalGeneralException.class})
 	public ResponseEntity<Object> handleInternalGeneralException(InternalGeneralException e){
 		
 		//creazione oggetto errorModel e return responseEntity
 		ErrorModel errorModel = new ErrorModel(
 						HttpStatus.INTERNAL_SERVER_ERROR,
 						Instant.now(),
 						e.getClass().getCanonicalName(),
 						e.getMessage()
 						);
 		
 		return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
