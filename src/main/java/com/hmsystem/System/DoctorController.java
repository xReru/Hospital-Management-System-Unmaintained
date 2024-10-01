/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmsystem.System;

/**
 *
 * @author Janrell Quiaroro
 */
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmsystem.System.entity.Doctor;
import com.hmsystem.System.repository.DoctorRepository;

@Controller
@RequestMapping("/doctors/")
public class DoctorController {

	@Autowired
	private DoctorRepository doctorRepository;	
	
	@GetMapping("showDoctor")
	public String showPatientForm(Doctor doctor) {
		return "Admin/addDoctor";
	}
	
	@GetMapping("list")
	public String patients(Model model) {
		model.addAttribute("doctors", this.doctorRepository.findAll());
		return "Admin/doctor-list";
	}
	
	@PostMapping("add")
	public String addPatient(@Valid Doctor doctor, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addPatient";
		}
		
		this.doctorRepository.save(doctor);
		return "redirect:list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Doctor doctor = this.doctorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid doctor id : " + id));
		
		model.addAttribute("doctor", doctor);
		return "Admin/updateDoctor";
	}
	
	@PostMapping("update/{id}")
	public String updatePatient(@PathVariable("id") long id, @Valid Doctor doctor, BindingResult result, Model model) {
		if(result.hasErrors()) {
			doctor.setId(id);
			return "Admin/updateDoctor";
		}
		
		// update doctor
		doctorRepository.save(doctor);
		
		// get all list of doctor ( with update)
		model.addAttribute("doctors", this.doctorRepository.findAll());
		return "Admin/doctor-list";
	}
	
	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable ("id") long id, Model model) {
		
		Doctor doctor = this.doctorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid doctor id : " + id));
		
		this.doctorRepository.delete(doctor);
		model.addAttribute("patients", this.doctorRepository.findAll());
		return "Admin/doctor-list";
		
	}
}
