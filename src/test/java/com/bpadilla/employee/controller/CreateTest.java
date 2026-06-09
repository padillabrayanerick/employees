package com.bpadilla.employee.controller;

import com.bpadilla.employee.dto.EmployeeResponse;
import com.bpadilla.employee.util.BaseControllerTest;
import com.bpadilla.employee.util.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
public class CreateTest extends BaseControllerTest {

    @Test
    void testCreate() throws Exception {

        List<EmployeeResponse> responses = List.of(sampleResponse);

        Mockito.when(service.create(anyList())).thenReturn(responses);

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Constants.requestBodyList))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].firstName").value("Juan"));
    }
}
