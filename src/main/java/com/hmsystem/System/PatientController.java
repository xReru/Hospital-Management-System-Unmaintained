/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmsystem.System;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmsystem.System.entity.Patient;
import com.hmsystem.System.repository.PatientRepository;

@Controller
@RequestMapping("/patients/")
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;	
	
	@GetMapping("showPatient")
	public String showPatientForm(Patient patient) {
		return "Admin/addPatient";
	}
	
	@GetMapping("list")
	public String patients(Model model) {
		model.addAttribute("patients", this.patientRepository.findAll());
		return "Admin/patient-list";
	}
	
	@PostMapping("add")
	public String addPatient(@Valid Patient patient, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addPatient";
		}
		
		this.patientRepository.save(patient);
		return "redirect:list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Patient patient = this.patientRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid patient id : " + id));
		
		model.addAttribute("patient", patient);
		return "Admin/updatePatient";
	}
	
	@PostMapping("update/{id}")
	public String updatePatient(@PathVariable("id") long id, @Valid Patient patient, BindingResult result, Model model) {
		if(result.hasErrors()) {
			patient.setId(id);
			return "Admin/updatePatient";
		}
		
		// update patient
		patientRepository.save(patient);
		
		// get all list of patients ( with update)
		model.addAttribute("patients", this.patientRepository.findAll());
		return "Admin/patient-list";
	}
	
	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable ("id") long id, Model model) {
		
		Patient patient = this.patientRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid patient id : " + id));
		
		this.patientRepository.delete(patient);
		model.addAttribute("patients", this.patientRepository.findAll());
		return "Admin/patient-list";
		
	}
}
