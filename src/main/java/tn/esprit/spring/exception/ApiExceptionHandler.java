package tn.esprit.spring.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = {NotSubscribedException.class})
	public ResponseEntity<Object> handleNotSubscribedException(NotSubscribedException e){
		Exception exception = new Exception( 
				e.getMessage(),
				HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
}
