package com.spring.project.HospitalManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.project.HospitalManagement.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, String speciality);
}
