package com.senzo.qettal.notifications.push;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class PushDTO {

	@JsonProperty
	private String title;
	@JsonProperty
	private String message;

	public PushDTO(String title, String message) {
		this.title = title;
		this.message = message;
	}

}
