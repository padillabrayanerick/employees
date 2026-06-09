package com.bpadilla.employee.controller;

import com.bpadilla.employee.util.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
public class DeleteTest extends BaseControllerTest{

    @Test
    public void deleteTest() throws Exception {

        mockMvc.perform(delete("/employees/{id}", 1L))
                .andExpect(status().isOk()).andDo(print());

    }
}
