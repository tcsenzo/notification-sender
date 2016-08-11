package com.senzo.qettal.notifications.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senzo.qettal.event.EventListDTO;
import com.senzo.qettal.notifications.NotificationSender;

@Component
public class EmailSender implements NotificationSender{

	@Autowired
	private AmazonSNS sns;
	@Autowired
	private ObjectMapper jackson;
	@Value("${aws.sns.topic.allDevices}")
	private String allDevicesTopic;
	
	public void send(EventListDTO events) {
		if(events.isEmpty()){
			return;
		}
		try {
			EmailDTO push = new EmailDTO("Que tal?", "Temos novos eventos para você");
			PublishRequest request = new PublishRequest(allDevicesTopic, jackson.writeValueAsString(push));
			sns.publish(request);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
