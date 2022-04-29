package com.revature;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfiguration {

	/*
	 * Every service that will be accessing our broker (which is ActiveMQ in this case as it is
	 * our JMS implementation) should be connected to the broker. As such, we will define an
	 * ActiveMQConnectionFactory bean.
	 */
	
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
	
	/*
	 * Connection pooling is recommended as it allows us to reuse connections that exist in a pool
	 * of connections.
	 */
	@Bean(destroyMethod = "stop")
	public PooledConnectionFactory pooledConnectionFactory(ActiveMQConnectionFactory jmsFactory) {
		return new PooledConnectionFactory(jmsFactory);
	}
	
	/*
	 * If you have a service that needs to check your queue in a nonblocking way, you need to add
	 * a ListenerContainerFactory bean to the container.
	 */
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(PooledConnectionFactory pooledConnectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
		configurer.configure(containerFactory, pooledConnectionFactory);
		/*
		 * This enables you to write to topics rather than queues as the default assumption is that
		 * you're only working with queues. A topic, unlike a queue, can broadcast the same message
		 * to multiple services.
		 */
		containerFactory.setPubSubDomain(true);
		return containerFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(PooledConnectionFactory pooledConnectionFactory) {
		return new JmsTemplate(pooledConnectionFactory);
	}
	
	/*
	 * A Destination can either be a queue or a topic. By default, ActiveMQ will work as a
	 * queue, but you can turn on support for topics later.
	 */
	@Bean
	public Destination simpleMessageQueue() {
		return new ActiveMQQueue("simpleMessageQueue");
	}
	
	@Bean
	public Destination simpleMessageTopic() {
		return new ActiveMQTopic("simpleMessageTopic");
	}
}
