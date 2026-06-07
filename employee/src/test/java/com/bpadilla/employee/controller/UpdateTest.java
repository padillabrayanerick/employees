package com.bpadilla.employee.controller;


import com.bpadilla.employee.dto.EmployeeRequest;
import com.bpadilla.employee.util.BaseControllerTest;
import com.bpadilla.employee.util.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest(controllers = EmployeeController.class)
public class UpdateTest extends BaseControllerTest {

    @Test
    void testUpdate() throws Exception {
        Mockito.when(service.update(eq(1L), any(EmployeeRequest.class))).thenReturn(sampleResponse);

        mockMvc.perform(put("/employees/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Constants.requestBody))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.firstName").value("Juan"));
    }
}
