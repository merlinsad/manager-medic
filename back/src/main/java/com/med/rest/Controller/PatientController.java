package com.med.rest.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.med.rest.domain.patientDTO.PatientDTO;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

	@PostMapping
	public void createPatient(@RequestBody PatientDTO patientDTO) {
	}
}
