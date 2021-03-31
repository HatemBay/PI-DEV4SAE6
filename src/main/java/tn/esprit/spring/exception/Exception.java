package tn.esprit.spring.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exception {
	
	private final String message;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;

	public Exception(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}
	
	
	

}
