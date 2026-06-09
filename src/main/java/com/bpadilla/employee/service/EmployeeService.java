package com.bpadilla.employee.service;

import com.bpadilla.employee.dto.EmployeeRequest;
import com.bpadilla.employee.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeResponse> getAll();
    public EmployeeResponse getById(Long id);
    public List<EmployeeResponse> create(List<EmployeeRequest> requests);
    public EmployeeResponse update(Long id, EmployeeRequest request);
    public void delete(Long id);
    public List<EmployeeResponse> searchByName(String name);
}
