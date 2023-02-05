package com.med.rest.domain.medicDTO;

public class UpdateMedicDTO {

	private Long id;
	private String name;
	private String phoneNumber;
	private String email;

	public UpdateMedicDTO(Long id, String name, String phoneNumber, String email) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
