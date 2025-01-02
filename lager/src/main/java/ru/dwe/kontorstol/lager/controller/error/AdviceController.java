package ru.dwe.kontorstol.lager.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.dwe.kontorstol.lager.exception.DBException;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleDBException(DBException ex) {
        ErrorResponse error = ErrorResponse.create(ex,
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}