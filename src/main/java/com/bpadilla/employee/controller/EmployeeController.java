package com.bpadilla.employee.controller;

import com.bpadilla.employee.dto.GenericResponse;
import com.bpadilla.employee.dto.EmployeeRequest;
import com.bpadilla.employee.dto.EmployeeResponse;
import com.bpadilla.employee.service.EmployeeService;
import com.bpadilla.employee.service.impl.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    private final EmployeeService service;
    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<List<EmployeeResponse>> create(@Valid @RequestBody List<EmployeeRequest> requests) {

            List<EmployeeResponse> created = service.create(requests);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long id, @Valid @RequestBody EmployeeRequest request) {
        EmployeeResponse updated = service.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse> delete(@PathVariable Long id) {

        service.delete(id);

        GenericResponse response = new GenericResponse();

        response.setStatus("OK");
        response.setCode(String.valueOf(HttpStatus.OK.value()));
        response.setResponse("El empleado con el id: "+id+" fue eliminado correctamente");
        return ResponseEntity.status(HttpStatus.OK).body(response);
//        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResponse>>
    searchByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.searchByName(name));
    }

}
