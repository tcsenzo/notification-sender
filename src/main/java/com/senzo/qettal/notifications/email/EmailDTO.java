package com.senzo.qettal.notifications.email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailDTO {

	@JsonProperty
	private String title;
	@JsonProperty
	private String message;

	public EmailDTO(String title, String message) {
		this.title = title;
		this.message = message;
	}

}
