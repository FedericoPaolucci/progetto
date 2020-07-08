/**
 * 
 */
package com.project.EsameProgettoTwitter.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;

/**E' la classe i cui oggetti sono gli errori da restituire al client.
 * @author Federico Paolucci
 */
public class ErrorModel {

	private final HttpStatus httpStatus;
	private final Instant instant;
	private final String errorName;
	private final String message;

	
	public ErrorModel(HttpStatus httpStatus, Instant instant, String errorName, String message) {

		this.httpStatus = httpStatus;
		this.instant = instant;
		this.errorName = errorName;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public Instant getInstant() {
		return instant;
	}

	public String geterrorName() {
		return errorName;
	}

	public String getMessage() {
		return message;
	}
}
