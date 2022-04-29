package com.revature;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfiguration {

	@Bean
	public ActiveMQConnectionFactory jmsFactory() {
		ActiveMQConnectionFactory jmsFactory = new ActiveMQConnectionFactory();
		jmsFactory.setBrokerURL("tcp://localhost:61616");
		/*
		 * You must allow for serialization and deserialization of DTOs when using JMS. You
		 * specify the trusted Java packages that you will allow JMS to serialize/deserialize
		 * for you.
		 */
		List<String> trustedPackages = new ArrayList<>();
		trustedPackages.add("com.revature.dto");
		jmsFactory.setTrustedPackages(trustedPackages);
		return jmsFactory;
	}
	
	@Bean(destroyMethod = "stop")
	public PooledConnectionFactory pooledConnectionFactory(ActiveMQConnectionFactory jmsFactory) {
		return new PooledConnectionFactory(jmsFactory);
	}
	
	@Bean
	public JmsTemplate jmsTemplate(PooledConnectionFactory pooledConnectionFactory) {
		return new JmsTemplate(pooledConnectionFactory);
	}
	
	@Bean
	public Destination simpleMessageQueue() {
		return new ActiveMQQueue("simpleMessageQueue");
	}
	
	@Bean
	public Destination simpleMessageTopic() {
		return new ActiveMQTopic("simpleMessageTopic");
	}
}
