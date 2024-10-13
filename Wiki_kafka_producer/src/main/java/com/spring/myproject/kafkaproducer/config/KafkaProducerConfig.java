package com.spring.myproject.kafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerConfig.class);
	
	@Bean
	 NewTopic topic()
	{
		logger.info("creating topic for producer");
		return TopicBuilder.name("wikimedia_recentchanges").build();
	}

}
