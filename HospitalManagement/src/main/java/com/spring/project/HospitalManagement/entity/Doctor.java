package com.spring.project.HospitalManagement.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should be at least 3 characters")
    private String name;

    @Pattern(regexp = "Delhi|Noida|Faridabad", message = "City must be one of Delhi, Noida, Faridabad")
    private String city;

    @Email
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number should be at least 10 digits")
    private String phone;

    @Pattern(regexp = "Orthopaedic|Gynecology|Dermatology|ENT", message = "Speciality must be one of Orthopaedic, Gynecology, Dermatology, ENT")
    private String speciality;
}