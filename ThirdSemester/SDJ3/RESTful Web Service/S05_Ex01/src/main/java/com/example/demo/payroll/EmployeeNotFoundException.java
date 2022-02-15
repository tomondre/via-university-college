package com.example.demo.payroll;

class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}