package com.senzo.qettal.push;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PushSenderController {

	@RequestMapping("/send")
	public EventListDTO send(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8080/events", EventListDTO.class);
	}
	
}
