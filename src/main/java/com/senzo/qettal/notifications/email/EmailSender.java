package com.senzo.qettal.notifications.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sns.AmazonSNS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senzo.qettal.event.EventListDTO;
import com.senzo.qettal.notifications.NotificationSender;

@Component
public class EmailSender implements NotificationSender {

	@Autowired
	private AmazonSNS sns;
	@Autowired
	private ObjectMapper jackson;
	@Value("${aws.sns.topic.allDevices}")
	private String allDevicesTopic;
	@Autowired
	private MailSender sender;

	public void send(EventListDTO events) {
		if (events.isEmpty()) {
			return;
		}
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("qettal.senzo@gmail.com");
		msg.setTo("leocwolter@gmail.com");
		msg.setSubject("Que tal?");
		msg.setText("Temos novos eventos para você");
		sender.send(msg);
	}
}
