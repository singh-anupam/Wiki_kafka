package com.spring.myproject.kafkaproducer.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class KafkaProducerService {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public String sendMessage() throws InterruptedException 
	{
		logger.info("sending messgae from KafkaProducerService");
		String topic = "wikimedia_recentchanges";
//		EventHandler eventHandler = new KafkaProducerHandler(kafkaTemplate,topic);
//		
//		String URL ="https://stream.wikimedia.org/v2/stream/recentchange";
//		EventSource.Builder eventSourceBuilder = new EventSource.Builder(eventHandler, URI.create(URL));
//		EventSource eventSource = eventSourceBuilder.build();
//		eventSource.start();
		
		kafkaTemplate.send(topic,"my kafka message");
		
		return "send message successfully";
	//	TimeUnit.MINUTES.sleep(5);
		
	}
	
	

}
