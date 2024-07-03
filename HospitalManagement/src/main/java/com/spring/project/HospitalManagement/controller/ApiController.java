package com.spring.project.HospitalManagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.HospitalManagement.entity.Doctor;
import com.spring.project.HospitalManagement.entity.Patient;
import com.spring.project.HospitalManagement.service.DoctorService;
import com.spring.project.HospitalManagement.service.PatientService;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable Long id) {
        doctorService.removeDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> removePatient(@PathVariable Long id) {
        patientService.removePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/suggest/{patientId}")
    public ResponseEntity<String> suggestDoctors(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            return ResponseEntity.badRequest().body("Invalid patient ID");
        }

        String speciality = null;
        switch (patient.getSymptom()) {
            case "Arthritis":
            case "Back Pain":
            case "Tissue injuries":
                speciality = "Orthopaedic";
                break;
            case "Dysmenorrhea":
                speciality = "Gynecology";
                break;
            case "Skin infection":
            case "Skin burn":
                speciality = "Dermatology";
                break;
            case "Ear pain":
                speciality = "ENT";
                break;
        }

        List<Doctor> doctors = doctorService.suggestDoctors(patient.getCity(), speciality);
        if (doctors.isEmpty()) {
            if (patient.getCity().equals("Delhi") || patient.getCity().equals("Noida") || patient.getCity().equals("Faridabad")) {
                return ResponseEntity.ok("There isn’t any doctor present at your location for your symptom”");
            } else {
                return ResponseEntity.ok("We are still waiting to expand to your location");
            }
        }

        return ResponseEntity.ok(doctors.toString());
    }
}