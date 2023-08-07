package com.zakharov.dairy.crypto.exception.handler;

import com.zakharov.dairy.crypto.exception.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(RuntimeException e){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("message",e.getMessage());
        return new ResponseEntity<>(body, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler( value = {ConstraintViolationException.class})
    public ResponseEntity<Object> handleValidationException(ConstraintViolationException e){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("message",e.getMessage());
        return new ResponseEntity<>(body, HttpStatusCode.valueOf(422));
    }
}
