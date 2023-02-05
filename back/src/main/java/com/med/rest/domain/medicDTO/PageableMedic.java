package com.med.rest.domain.medicDTO;

import org.hibernate.mapping.List;

public class PageableMedic {

	private List listMedics;
	private Long page;
	private Long size;

	public List getListMedics() {
		return listMedics;
	}

	public void setListMedics(List listMedics) {
		this.listMedics = listMedics;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
