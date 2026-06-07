package com.bpadilla.employee.dto;

import com.bpadilla.employee.model.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.time.LocalDate;
import lombok.Data;

@Data
public class EmployeeResponse {

    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String motherLastName;
    private Integer age;
    private Sex sex;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    private String position;
    private Instant createdAt;
    private Boolean active;

}
