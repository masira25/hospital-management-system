package com.hospital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.entity.Appointment;
import com.hospital.management.entity.Doctor;
import com.hospital.management.entity.Patient;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.repository.PatientRepository;

@RestController
public class ApiController {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    // ================= DOCTOR APIs =================

    @GetMapping("/api/doctors")
    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }

    @PostMapping("/api/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    // ================= PATIENT APIs =================

    @GetMapping("/api/patients")
    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    @PostMapping("/api/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepo.save(patient);
    }

    // ================= APPOINTMENT APIs =================

    @GetMapping("/api/appointments")
    public List<Appointment> getAppointments() {
        return appointmentRepo.findAll();
    }

    @PostMapping("/api/appointments")
    public Appointment addAppointment(@RequestBody Appointment appointment) {

        appointment.setStatus("Pending");

        return appointmentRepo.save(appointment);
    }
}