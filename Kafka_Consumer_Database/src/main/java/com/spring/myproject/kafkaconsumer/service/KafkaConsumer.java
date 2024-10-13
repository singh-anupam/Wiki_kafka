package com.spring.myproject.kafkaconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private static final Logger logger  = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(
			topics ="wikimedia_recentchanges",
			groupId = "myGroup")
	public String consume(String messageEvent)
	{
		logger.info(String.format("KafkaConsumer recieved message events -> %s",messageEvent));
		
		return "message recieved";
		
		
	}

}
