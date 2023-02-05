package com.med.rest.infra.exception;

public class ExceptionPostMedicError400DTO {

	private String field;
	private String error;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
