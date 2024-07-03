package com.spring.project.HospitalManagement.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should be at least 3 characters")
    private String name;

    @NotEmpty(message = "City should be at max 20 characters")
    private String city;

    @Email
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number should be at least 10 digits")
    private String phone;

    @Pattern(regexp = "Arthritis|Back Pain|Tissue injuries|Dysmenorrhea|Skin infection|Skin burn|Ear pain", message = "Invalid symptom")
    private String symptom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSymptom() {

		return symptom;
	}

	public void setSymptom(String symptom) {

		this.symptom = symptom;
	}


}
