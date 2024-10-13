package com.spring.myproject.kafkaproducer.service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class KafkaProducerHandler  implements EventHandler{

	private KafkaTemplate<String, String> kafkaTemplate;
	
	private String topic;
	
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerHandler.class);
	
	public KafkaProducerHandler(KafkaTemplate<String, String> template, String topic)
	{
		this.kafkaTemplate = template;
		this.topic = topic;
	}
 
	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("wiki on message recieved" + messageEvent.getData());
		 CompletableFuture<SendResult<String, String>> completable = kafkaTemplate.send(topic,messageEvent.getData());
		 completable.whenComplete((result,error)->
		 {
			 if(Objects.nonNull(result))
			 {
				 logger.error("Failed to send message "+messageEvent.getData());
				 throw new RuntimeException("Failed to send messgae");
			 }
			 else
				 logger.info("Message sent successfully");
			
		 });
		
		
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
