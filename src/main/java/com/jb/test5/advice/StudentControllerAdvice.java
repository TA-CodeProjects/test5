package com.jb.test5.advice;

import com.jb.test5.exceptions.SchoolSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentControllerAdvice {
    @ExceptionHandler(value = {SchoolSystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleError(Exception e){
        return new ErrorDetails("Saas", e.getMessage());
    }
}
