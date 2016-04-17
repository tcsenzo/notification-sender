package com.senzo.qettal.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;

@Component
public class PushNotificationSender {

	@Autowired
	private AmazonSNS sns;

	public void send(EventListDTO events) {
		if(events.isEmpty()){
			return;
		}
		PublishRequest request = new PublishRequest("arn:aws:sns:us-east-1:417703597935:qettal_alldevices_MOBILEHUB_1994879436", "teste maroto", "titulo");
		sns.publish(request);
	}
}
