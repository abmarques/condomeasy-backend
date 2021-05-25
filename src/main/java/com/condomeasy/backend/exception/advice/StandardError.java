package com.condomeasy.backend.exception.advice;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer status;
	private LocalDateTime datetime;
	private String message;

	public StandardError(Integer status,  LocalDateTime datetime, String message) {
		super();
		this.status = status;
		this.datetime = datetime;
		this.message = message;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
