package com.bpadilla.employee.entity;

import com.bpadilla.employee.model.Sex;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Data
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="second_name")
    private String secondName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="mother_last_name")
    private String motherLastName;

    @Column(name="age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name="sex")
    private Sex sex;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "position")
    private String position;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "active")
    private boolean active;
}
