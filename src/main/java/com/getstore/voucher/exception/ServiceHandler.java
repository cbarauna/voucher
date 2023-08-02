package com.getstore.voucher.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ServiceHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({RuntimeException.class, DuplicateKeyException.class})
    public ResponseEntity<Error> error(Exception exception) {
        return new ResponseEntity<>(getError(exception), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Error getError(Exception exception) {
        Error error = new Error();
        error.setErro(String.valueOf(exception.getCause()));
        error.setEstatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessagem(exception.getMessage());
        return error;
    }

}
