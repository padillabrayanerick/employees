package com.bpadilla.employee.dto;

import com.bpadilla.employee.model.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.Data;

@Data
public class EmployeeRequest {

    @NotBlank(message = "Primer nombre es requerido")
    private String firstName;

    private String secondName;

    @NotBlank(message = "Apellido paterno es requerido")
    private String lastName;

    private String motherLastName;

    @Min(value = 0, message = "Edad no puede ser negativa")
    private Integer age;

    private Sex sex;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Puesto es requerido")
    private String position;

    private Boolean active;

}
