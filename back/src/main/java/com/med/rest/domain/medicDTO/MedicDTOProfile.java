package com.med.rest.domain.medicDTO;

import com.med.rest.domain.entitys.Medic;

import jakarta.validation.constraints.NotBlank;

public class MedicDTOProfile {

	@NotBlank private String email;
	@NotBlank private String name;
	@NotBlank private Long crm;
	@NotBlank private String specialty;
	@NotBlank private Long id;

	public MedicDTOProfile() {
	}

	public MedicDTOProfile(Medic medic) {
		this.crm = medic.getCrm();
		this.email = medic.getEmail();
		this.name = medic.getName();
		this.specialty = medic.getSpecialty();
		this.id = medic.getId();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}