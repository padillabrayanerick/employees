package com.bpadilla.employee.controller;

import com.bpadilla.employee.dto.EmployeeResponse;
import com.bpadilla.employee.util.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
public class GetAllTest extends BaseControllerTest {

    @Test
    void testGetAll() throws Exception {

//        List<EmployeeResponse> responses = List.of(sampleResponse);
        Mockito.when(service.getAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk());
    }
}