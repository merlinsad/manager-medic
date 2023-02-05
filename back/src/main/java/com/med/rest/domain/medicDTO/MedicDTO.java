package com.med.rest.domain.medicDTO;

import java.io.Serializable;

import com.med.rest.domain.entitys.Medic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MedicDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "O campo Nome não pode estar vazio.")
	private String name;

	@Email
	@NotBlank(message = "O campo E-mail não pode estar vazio.")
	private String email;

	@NotNull(message = "O campo Crm não pode estar vazio.")
	private Long crm;

	@NotBlank(message = "O campo Especialidade não pode estar vazio.")
	private String specialty;

	@Valid
	@NotNull
	private AddressDTO addressDTO;

	@NotNull(message = "O campo Telefone não pode estar vazio.")
	private String phoneNumber;

	public MedicDTO() {
	}

	public MedicDTO(Medic medic) {
		this.name = medic.getName();
		this.email = medic.getEmail();
		this.crm = medic.getCrm();
		this.specialty = medic.getSpecialty();
		this.phoneNumber = medic.getPhoneNumber();
	}

	public MedicDTO(@NotBlank String name, @NotBlank @Email String email, @NotNull Long crm, @NotBlank String specialty, @NotNull @Valid AddressDTO addressDTO, @NotNull String phoneNumber) {
		this.name = name;
		this.email = email;
		this.crm = crm;
		this.specialty = specialty;
		this.addressDTO = addressDTO;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}