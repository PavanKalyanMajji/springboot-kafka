package com.tcs.restapi.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	
	@KafkaListener(topics = "kafka-producer",groupId = "kafka-consumers")
	public void messageConsumer(String message) {
		System.out.println("consumed message succesfully message is "+message);
	}
}
