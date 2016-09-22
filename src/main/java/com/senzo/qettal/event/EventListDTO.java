package com.senzo.qettal.event;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventListDTO {

	@JsonProperty("events")
	private List<EventDTO> eventDTOs;
	
	/**
	 * @deprecated Use the factory method
	 */
	private EventListDTO() {
	}

	public boolean isEmpty() {
		return eventDTOs.isEmpty();
	}

	public List<EventDTO> getItems() {
		return eventDTOs;
	}
	
}
