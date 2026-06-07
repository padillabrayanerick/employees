package com.bpadilla.employee.util;

import com.bpadilla.employee.dto.EmployeeRequest;
import com.bpadilla.employee.dto.EmployeeResponse;
import com.bpadilla.employee.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeUtil {

    public static Employee reqToEntity(EmployeeRequest req) {

        if (req == null)
            return null;

        Employee e = new Employee();
        e.setFirstName(req.getFirstName());
        e.setSecondName(req.getSecondName());
        e.setLastName(req.getLastName());
        e.setMotherLastName(req.getMotherLastName());
        e.setAge(req.getAge());
        e.setSex(req.getSex());
        e.setDateOfBirth(req.getDateOfBirth());
        e.setPosition(req.getPosition());
        if (req.getActive() != null) e.setActive(req.getActive());
        return e;
    }

    public static EmployeeResponse entToResponse(Employee e) {

        if (e == null)
            return null;

        EmployeeResponse r = new EmployeeResponse();
        r.setId(e.getId());
        r.setFirstName(e.getFirstName());
        r.setSecondName(e.getSecondName());
        r.setLastName(e.getLastName());
        r.setMotherLastName(e.getMotherLastName());
        r.setAge(e.getAge());
        r.setSex(e.getSex());
        r.setDateOfBirth(e.getDateOfBirth());
        r.setPosition(e.getPosition());
        r.setCreatedAt(e.getCreatedAt());
        r.setActive(e.isActive());
        return r;
    }

    public static List<EmployeeResponse> toResponseList(List<Employee> list)
    {
        return
                list.stream().map(EmployeeUtil::entToResponse).collect(Collectors.toList());
    }

}
