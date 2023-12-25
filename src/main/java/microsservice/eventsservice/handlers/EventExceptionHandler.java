package microsservice.eventsservice.handlers;

import microsservice.eventsservice.exceptions.EventFullException;
import microsservice.eventsservice.exceptions.EventNotFoundException;
import microsservice.eventsservice.exceptions.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EventExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    private ResponseEntity<RestErrorMessage>  eventNotFoundErrorHandler(EventNotFoundException exception){
        RestErrorMessage threatErrorResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatErrorResponse);
    }

    @ExceptionHandler(EventFullException.class)
    private ResponseEntity<RestErrorMessage>  eventFullErrorHandler(EventFullException exception){
        RestErrorMessage threatErrorResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatErrorResponse);
    }
}
