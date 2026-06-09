package com.bpadilla.employee.util;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Empleado con id: " + id + " no encontrado ");
    }
}
