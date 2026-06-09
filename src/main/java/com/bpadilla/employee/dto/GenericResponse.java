package com.bpadilla.employee.dto;

import lombok.Data;

@Data
public class GenericResponse {

    private String status;
    private String code;
    private String response;
}
