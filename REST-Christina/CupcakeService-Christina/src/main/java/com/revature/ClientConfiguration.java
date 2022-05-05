package com.revature;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import com.revature.soap.service.OrderService;

@Configuration
public class ClientConfiguration {
	
	/*
	 * I've added the Spring Remoting dependency to allow for easier Java serialization over HTTP. This application,
	 * which is the client to my SOAP service, does not require any knowledge of HTTP being used, nor do we have to
	 * worry about setting up marshallers or HTTP message converters. 
	 * 
	 * The JaxWsPortProxyFactoryBean is a proxy object. When we invoke any methods on the OrderService type (which is
	 * just an abstract type in this project), the proxy bean will facilitate the actual communication with our 
	 * running SOAP service. This proxy bean abstracts away the process of making the HTTP request to the service ourselves
	 * and unmarshalling the XML upon its arrival.
	 */
	
	@Bean
	public JaxWsPortProxyFactoryBean serviceProxy() {
		JaxWsPortProxyFactoryBean proxyFactory = new JaxWsPortProxyFactoryBean();
		
		try {
			proxyFactory.setWsdlDocumentUrl(new URL("http://localhost:8081/soap-service/order-service?wsdl"));
			proxyFactory.setServiceInterface(OrderService.class);
			
			proxyFactory.setServiceName("OrderServiceImplService");
			proxyFactory.setPortName("orderPort");
			proxyFactory.setNamespaceUri("http://service.revature.com/");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		return proxyFactory;
	}
	

}

