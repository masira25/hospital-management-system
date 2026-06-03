package com.hospital.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.management.entity.Appointment;
import com.hospital.management.entity.Doctor;
import com.hospital.management.entity.Patient;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.repository.PatientRepository;

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

    @GetMapping("/deleteDoctor/{id}")
public String deleteDoctor(@PathVariable Long id) {

    doctorRepo.deleteById(id);

    return "redirect:/";
}

@GetMapping("/deletePatient/{id}")
public String deletePatient(@PathVariable Long id) {

    patientRepo.deleteById(id);

    return "redirect:/";
}

@GetMapping("/deleteAppointment/{id}")
public String deleteAppointment(@PathVariable Long id) {

    appointmentRepo.deleteById(id);

    return "redirect:/";
}

@GetMapping("/editDoctor/{id}")
public String editDoctor(@PathVariable Long id, Model model) {

    Doctor doctor = doctorRepo.findById(id).orElse(null);

    model.addAttribute("doctor", doctor);

    return "editDoctor";
}

@PostMapping("/updateDoctor")
public String updateDoctor(Doctor doctor) {

    doctorRepo.save(doctor);

    return "redirect:/";
}
}