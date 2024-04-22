package com.tcs.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

@Service
public class KafkaProducerService {
	
	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;
	
	public void messagePublisher(String message) {
		ListenableFuture<SendResult<String, Object>> future=kafkaTemplate.send("kafka-producer", message);
		future.addCallback(new SuccessCallback<Object>() {
			@Override
			public void onSuccess(Object result) {
				System.out.println("Sucessfully Published the message "+message);
			}
			
		}, new FailureCallback() {
			
			@Override
			public void onFailure(Throwable ex) {
				System.out.println("unable to Publish the message due to "+ex.getMessage());
			}
		});
	}
}
