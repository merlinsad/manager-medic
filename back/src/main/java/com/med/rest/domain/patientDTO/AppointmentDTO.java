package com.med.rest.domain.patientDTO;

import java.io.Serializable;

public class AppointmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String date;
	private String time;
	private String reason;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
