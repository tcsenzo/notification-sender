package com.senzo.qettal.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PushSenderController {

	@Autowired
	private PushNotificationSender sender;
	
	@RequestMapping("/send")
	public EventListDTO send(){
		RestTemplate restTemplate = new RestTemplate();
		EventListDTO events = restTemplate.getForObject("http://localhost:8080/events", EventListDTO.class);
		sender.send(events);
		return events;
	}
	
}
