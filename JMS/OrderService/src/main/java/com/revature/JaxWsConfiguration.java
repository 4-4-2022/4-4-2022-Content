package com.revature;

import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.service.OrderServiceImpl;

@Configuration
public class JaxWsConfiguration {

	@Bean
	public ServletRegistrationBean<CXFServlet> cxfServlet(){
		//All services are going to be located under "/soap-service". Note that "*" is just a wildcard.
		return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/soap-service/*");
	}
	
	/*
	 * The Bus is the central place in CXF. It is is primarily responsible for providing access to different extensions.
	 * It is also responsible for wiring up CXF internals.
	 * 
	 * Please note that the "SpringBus" abstracts away the bus configuration needed for CXF.
	 * 
	 * This bean MUST be named "cxf".
	 */
	@Bean(name = "cxf")
	public SpringBus springBus() {
		return new SpringBus();
	}
	
	@Bean
	public OrderServiceImpl orderServiceImpl() {
		return new OrderServiceImpl();
	}
	
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), orderServiceImpl());
		/*
		 * We need to expose the endpoing under an address. We have to publish endpoint ourself; it's not immediately
		 * consumable.
		 */
		endpoint.publish("/order-service");
		return endpoint;
	}
	
}
