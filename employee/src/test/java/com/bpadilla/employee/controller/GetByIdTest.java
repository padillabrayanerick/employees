package com.bpadilla.employee.controller;

import com.bpadilla.employee.util.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
public class GetByIdTest extends BaseControllerTest {

    @Test
    void testGetById() throws Exception {
        Mockito.when(service.getById(1L)).thenReturn(sampleResponse);

        mockMvc.perform(get("/employees/{id}", 1L)).andDo(print()).andExpect(status().isOk());
    }
}
