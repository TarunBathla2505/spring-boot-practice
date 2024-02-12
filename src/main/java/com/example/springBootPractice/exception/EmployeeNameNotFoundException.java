package com.example.springBootPractice.exception;

public class EmployeeNameNotFoundException extends EmployeeNotFoundException{
    public EmployeeNameNotFoundException(String message) {
        super(message);
    }
}
