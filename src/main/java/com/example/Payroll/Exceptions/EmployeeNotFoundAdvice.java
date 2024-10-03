package com.example.Payroll.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//signals advice is rendered straight into response Body
@RestControllerAdvice
public class EmployeeNotFoundAdvice {

    //configures the advice to only respond when EmployeeNotFoundException is thrown
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNtFoundHandler(EmployeeNotFoundException ex){
        return ex.getMessage();
    }
}
