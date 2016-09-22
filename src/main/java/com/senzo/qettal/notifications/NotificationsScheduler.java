package com.senzo.qettal.notifications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.senzo.qettal.event.EventListDTO;

@Component
public class NotificationsScheduler {

	@Autowired
	private List<NotificationSender> senders;
	@Value("${url.theaterEvents}")
	private String eventsUrl;
	
	@Scheduled(cron = "0 0 10 * * *")
	public void send(){
		RestTemplate restTemplate = new RestTemplate();
		EventListDTO events = restTemplate.getForObject(eventsUrl, EventListDTO.class);
		for (NotificationSender sender : senders) {
			sender.send(events);
		}	
	}
	
}
