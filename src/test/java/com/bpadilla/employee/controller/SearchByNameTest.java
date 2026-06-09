package com.bpadilla.employee.controller;

import com.bpadilla.employee.dto.EmployeeResponse;
import com.bpadilla.employee.util.BaseControllerTest;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
public class SearchByNameTest extends BaseControllerTest {

    @Test
    public void searchByNameTest() throws Exception{

        List<EmployeeResponse> responses = List.of(sampleResponse);

        Mockito.when(service.searchByName("Juan")).thenReturn(responses);

        mockMvc.perform(get("/employees/search")
                        .param("name", "Juan")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$[0].firstName").value("Juan"));

    }
}
