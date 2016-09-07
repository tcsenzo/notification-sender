package com.senzo.qettal.notifications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.senzo.qettal.event.EventListDTO;

@RestController
public class NotificationsController {

	@Autowired
	private List<NotificationSender> senders;
	@Value("${url.theaterEvents}")
	private String eventsUrl;
	
	@RequestMapping("/send")
	public EventListDTO send(){
		RestTemplate restTemplate = new RestTemplate();
		EventListDTO events = restTemplate.getForObject(eventsUrl, EventListDTO.class);
		for (NotificationSender sender : senders) {
			sender.send(events);
		}
		return events;
	}
	
}
