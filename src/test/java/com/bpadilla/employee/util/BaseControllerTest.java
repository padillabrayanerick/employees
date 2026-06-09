package com.bpadilla.employee.util;

import com.bpadilla.employee.dto.EmployeeRequest;
import com.bpadilla.employee.dto.EmployeeResponse;
import com.bpadilla.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest
public abstract class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected EmployeeService service;

    public EmployeeResponse sampleResponse;

    public EmployeeRequest sampleRequest;

    @BeforeEach
    void setUp() {
        sampleResponse = new EmployeeResponse();
        sampleResponse.setId(1L);
        sampleResponse.setFirstName("Juan");
        sampleResponse.setLastName("Perez");
    }

}