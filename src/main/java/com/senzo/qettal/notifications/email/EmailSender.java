package com.senzo.qettal.notifications.email;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

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
	private JavaMailSender sender;
	@Autowired
	private VelocityEngine engine;

	public void send(EventListDTO eventsList) {
		if (eventsList.isEmpty()) {
			return;
		}
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper msg = new MimeMessageHelper(mimeMessage);
				msg.setTo(new String[]{"leocwolter@gmail.com", "gcastromelo94@gmail.com"});
				msg.setFrom("qettal.senzo@gmail.com");
				msg.setSubject("Está sem nada para fazer? Temos algumas dicas!");
				Map<String, Object> model = new HashMap<>();
				model.put("events", eventsList.getItems());
				String body = VelocityEngineUtils.mergeTemplateIntoString(engine, "events.vm", "utf-8", model);
				msg.setText(body, true);
			}
		};
		sender.send(preparator);
	}
}
