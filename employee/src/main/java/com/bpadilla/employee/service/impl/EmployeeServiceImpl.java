package com.bpadilla.employee.service.impl;

import com.bpadilla.employee.dto.EmployeeRequest;
import com.bpadilla.employee.dto.EmployeeResponse;
import com.bpadilla.employee.entity.Employee;
import com.bpadilla.employee.repository.EmployeeRepository;
import com.bpadilla.employee.service.EmployeeService;
import com.bpadilla.employee.util.EmployeeNotFoundException;
import com.bpadilla.employee.util.EmployeeUtil;
import com.sun.xml.bind.v2.TODO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<EmployeeResponse> getAll() {
        log.debug("Obteniendo todos los empleados de la base de datos...");
        return repository.findAll().stream().map(EmployeeUtil::entToResponse).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getById(Long id) {
        Employee e = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return EmployeeUtil.entToResponse(e);
    }

    @Override
    @Transactional
    public List<EmployeeResponse> create(List<EmployeeRequest> requests) {
        List<Employee> entities = requests.stream().map(EmployeeUtil::reqToEntity).collect(Collectors.toList());
        List<Employee> saved = repository.saveAll(entities);
        return saved.stream().map(EmployeeUtil::entToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeResponse update(Long id, EmployeeRequest request) {

        Employee existing_emp = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

        if (request.getFirstName() != null)
            existing_emp.setFirstName(request.getFirstName());
        if (request.getSecondName() != null)
            existing_emp.setSecondName(request.getSecondName());
        if (request.getLastName() != null)
            existing_emp.setLastName(request.getLastName());
        if (request.getMotherLastName() != null)
            existing_emp.setMotherLastName(request.getMotherLastName());
        if (request.getAge() != null)
            existing_emp.setAge(request.getAge());
        if (request.getSex() != null)
            existing_emp.setSex(request.getSex());
        if (request.getDateOfBirth() != null)
            existing_emp.setDateOfBirth(request.getDateOfBirth());
        if (request.getPosition() != null)
            existing_emp.setPosition(request.getPosition());
        if (request.getActive() != null)
            existing_emp.setActive(request.getActive());

        Employee saved = repository.save(existing_emp);
        return EmployeeUtil.entToResponse(saved);

    }

    @Override
    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id))
            throw new EmployeeNotFoundException(id);

        repository.deleteById(id);
    }

    @Override
    public List<EmployeeResponse> searchByName(String name) {

        String q = name == null ? "" : name.toLowerCase();

        return repository.searchByNameContainingIgnoreCase(q).stream().map(EmployeeUtil::entToResponse).collect(Collectors.toList());
    }
}
