package com.tcs.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.restapi.service.KafkaProducerService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private KafkaProducerService producerService;
	
/*
 * API used to test the Ping
 */
	@GetMapping("/pingtest")
	public String pingTest() {
		return "Ok";
	}
	
/*
 * API is used to publish the message to kafaka broker
 */
	@PostMapping("/message-publisher/{message}")
	public void messagePublisher(@PathVariable("message") String message) {
		producerService.messagePublisher(message);
	}
}
