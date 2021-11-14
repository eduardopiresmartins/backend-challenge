package application;

import java.net.http.HttpHeaders;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import antlr.collections.List;

@ControllerAdvice
public class GlobalExceptionalHandler extends ResponseEntityExceptionHandler {
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
		    MethodArgumentNotValidException ex,
		    HttpHeaders headers,
		    HttpStatus status,
		    WebRequest request
		  ) {

		    final List<String> errorList = ex.getBindingResult()
		      .getFieldErrors()
		      .stream()
		      .map(t -> t.getDefaultMessage())
		      .collect(Collectors.toList());

		    ErrorResponse response = new ErrorResponse();
		    response.setCode(HttpStatus.BAD_REQUEST.value());
		    response.setErrors(errorList);

		    return handleExceptionInternal(ex, response ,new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		  }

		}
}
