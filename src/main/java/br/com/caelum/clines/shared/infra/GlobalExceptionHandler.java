package br.com.caelum.clines.shared.infra;

import org.apache.logging.slf4j.SLF4JLogger;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.caelum.clines.shared.exceptions.AircraftModelNotFoundException;
import br.com.caelum.clines.shared.exceptions.LocationNotFoundException;
import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;
import br.com.caelum.clines.shared.exceptions.ViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private SLF4JLogger log;

	@ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void handle(ResourceNotFoundException e) {
        log.info("[RESOURCE_NOT_FOUND] {}", e.getMessage());
    }

    @ExceptionHandler(AircraftModelNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorView handle(AircraftModelNotFoundException e) {
        var message = e.getMessage();

        log.info("[AIRCRAFT_MODEL_NOT_FOUND] {}", message);

        var errorView = new ErrorView();
        errorView.addGenericError(message);

        return errorView;
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ErrorView handle(ResourceAlreadyExistsException e) {
        var message = e.getMessage();
        var errorView = new ErrorView();

        log.info("[RESOURCE_ALREADY_EXISTS] {}", message);

        errorView.addGenericError(message);

        return errorView;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorView handle(MethodArgumentNotValidException e) {
        var bindingResult = e.getBindingResult();
        var errorView = new ErrorView();

        bindingResult.getGlobalErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .forEach(errorView::addGenericError);

        bindingResult.getFieldErrors()
                .forEach(f -> errorView.addFieldError(f.getField(), f.getDefaultMessage()));

        log.info("[VALIDATION_ERROR] {}", errorView);

        return errorView;
    }

    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorView handle(LocationNotFoundException e) {
        var message = e.getMessage();

        log.info("[LOCATION_NOT_FOUND] {}", message);

        var errorView = new ErrorView();
        errorView.addGenericError(message);

        return errorView;
    }

    @ExceptionHandler(ViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorView handle(ViolationException e) {
        var errorView = new ErrorView();

        e.getViolations()
                .stream()
                .map(Throwable::getMessage)
                .forEach(errorView::addGenericError);

        return errorView;
    }
}
