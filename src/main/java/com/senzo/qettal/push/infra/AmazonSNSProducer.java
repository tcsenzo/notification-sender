package com.senzo.qettal.push.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;

@Configuration
public class AmazonSNSProducer {
	
	@Value("${aws.accessKey}")
	private String accessKey;
	
	@Value("${aws.secretKey}")
	private String secretKey;

	@Bean
	public AmazonSNS getInstance(){
		return new AmazonSNSClient(new BasicAWSCredentials(accessKey, secretKey));
	}
}
