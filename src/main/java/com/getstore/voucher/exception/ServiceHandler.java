package com.getstore.voucher.exception;

import org.springdoc.api.ErrorMessage;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
