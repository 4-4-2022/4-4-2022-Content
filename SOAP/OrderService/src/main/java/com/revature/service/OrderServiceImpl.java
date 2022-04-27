package com.revature.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Order;
import com.revature.repository.OrderRepository;

@WebService(endpointInterface = "com.revature.service.OrderService", name = "order")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private RestTemplate restTemplate;
	
	private OrderRepository orderRepository;
	
	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	@WebMethod
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return this.orderRepository.findAll();
	}

	@Override
	@WebMethod
	public void save(Order order) {
		this.orderRepository.save(order);
		
	}

	@Override
	@WebMethod
	public void contactCupcakeService(String message) {
		
		final String URI = "/cupcake-service?wsdl";
		final String SOAP_MESSAGE = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.revature.com/\">\r\n"
				+ "   <soapenv:Header/>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <ser:receiveMessage>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <arg0>" + message + "</arg0>\r\n"
				+ "      </ser:receiveMessage>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> request = new HttpEntity<>(SOAP_MESSAGE, header);
		this.restTemplate.postForLocation(URI, request);
	
	}
	
	

}
