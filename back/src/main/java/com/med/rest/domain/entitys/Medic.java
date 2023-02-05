package com.med.rest.domain.entitys;

import com.med.rest.domain.medicDTO.MedicDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	private Long id;

	@Embedded
	private Address address;

	private String name;
	private String email;
	private Long crm;
	private String specialty;
	private String phoneNumber;

	public Medic() {}

	public Medic(MedicDTO medicDTO) {
		this.name = medicDTO.getName();
		this.email = medicDTO.getEmail();
		this.crm = medicDTO.getCrm();
		this.specialty = medicDTO.getSpecialty();
		this.address = new Address(medicDTO.getAddressDTO());
		this.phoneNumber = medicDTO.getPhoneNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
