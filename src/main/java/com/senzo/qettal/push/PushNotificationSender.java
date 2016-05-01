package com.senzo.qettal.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PushNotificationSender {

	@Autowired
	private AmazonSNS sns;
	@Autowired
	private ObjectMapper jackson;
	
	public void send(EventListDTO events) {
		if(events.isEmpty()){
			return;
		}
		try {
			PushNotificationDTO push = new PushNotificationDTO("Que tal?", "Temos novos eventos para você");
			PublishRequest request = new PublishRequest("arn:aws:sns:us-east-1:417703597935:qettal_alldevices_MOBILEHUB_1994879436", jackson.writeValueAsString(push));
			sns.publish(request);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
