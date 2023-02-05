package com.med.rest.domain.entitys;

import com.med.rest.domain.medicDTO.AddressDTO;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String publicPlace;
	private String district;
	private Long cep;
	private String city;
	private String uf;
	private Integer number;
	private String complement;

	public Address() {}

	public Address(AddressDTO addressDTO) {
		this.publicPlace = addressDTO.getPublicPlace();
		this.district = addressDTO.getDistrict();
		this.cep = addressDTO.getCep();
		this.city = addressDTO.getCity();
		this.uf = addressDTO.getUf();
		this.number = addressDTO.getNumber();
		this.complement = addressDTO.getComplement();
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

}
