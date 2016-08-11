package com.senzo.qettal.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDTO {

	@JsonProperty
	private String name;
	@JsonProperty
	private String description;
	@JsonProperty
	private BigDecimal price;
	@JsonProperty("scheduled_date")
	private LocalDateTime scheduledDate;
	
	/**
	 * @deprecated Jackson eyes only
	 */
	EventDTO() {
	}
	
	public EventDTO(String name, String description, BigDecimal price, LocalDateTime scheduledDate) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.scheduledDate = scheduledDate;
	}
	
}
