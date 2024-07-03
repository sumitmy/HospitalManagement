package com.spring.project.HospitalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.HospitalManagement.entity.Doctor;
import com.spring.project.HospitalManagement.repository.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> suggestDoctors(String city, String speciality) {
        return doctorRepository.findByCityAndSpeciality(city, speciality);
    }

	public DoctorRepository getDoctorRepository() {
		return doctorRepository;
	}

	public void setDoctorRepository(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
}
