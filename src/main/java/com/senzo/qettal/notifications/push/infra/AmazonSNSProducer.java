package com.senzo.qettal.notifications.push.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;

@Configuration
public class AmazonSNSProducer {

	@Value("${cloud.aws.credentials.accessKey}")
	private String accessKey;
	@Value("${cloud.aws.credentials.secretKey}")
	private String secretKey;
	@Value("${cloud.aws.credentials.instanceProfile}")
	private String instanceProfile;
	@Value("${cloud.aws.region.static}")
	private String region;
	
	@Bean
	public AmazonSNS getSNS(){
		if(Boolean.getBoolean(instanceProfile)){
			return new AmazonSNSClient(new InstanceProfileCredentialsProvider());
		}
		return new AmazonSNSClient(new BasicAWSCredentials(accessKey, secretKey));
	}
}
