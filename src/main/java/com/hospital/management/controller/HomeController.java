package com.hospital.management.controller;

import com.hospital.management.entity.*;
import com.hospital.management.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("doctors", doctorRepo.findAll());
        model.addAttribute("patients", patientRepo.findAll());
        model.addAttribute("appointments", appointmentRepo.findAll());

        return "index";
    }

    @PostMapping("/addDoctor")
    public String addDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
        return "redirect:/";
    }

    @PostMapping("/addPatient")
    public String addPatient(Patient patient) {
        patientRepo.save(patient);
        return "redirect:/";
    }

    @PostMapping("/addAppointment")
    public String addAppointment(Appointment appointment) {
        appointment.setStatus("Pending");
        appointmentRepo.save(appointment);
        return "redirect:/";
    }
}