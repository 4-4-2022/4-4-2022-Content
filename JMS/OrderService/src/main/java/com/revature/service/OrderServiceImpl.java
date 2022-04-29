package com.revature.service;

import java.util.List;
import java.util.Map;

import javax.jms.Destination;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.client.RestTemplate;

import com.revature.dto.CupcakePurchaseDto;
import com.revature.model.Item;
import com.revature.model.Order;
import com.revature.model.OrderFlavorKey;
import com.revature.repository.ItemRepository;
import com.revature.repository.OrderRepository;

@WebService(endpointInterface = "com.revature.service.OrderService", name = "order")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Destination simpleMessageTopic;
	
	private OrderRepository orderRepository;
	private ItemRepository itemRepository;
	
	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Autowired
	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Override
	@WebMethod
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return this.orderRepository.findAll();
	}

	@Override
	@WebMethod
	public void save(Order order, Map<String, Integer> items) {
		//Store the order to immediately use the id in the Quantity table
		Order savedOrder = this.orderRepository.save(order);
		for(String flavor : items.keySet()) {
			OrderFlavorKey orderFlavorKey = new OrderFlavorKey(savedOrder, flavor);
			Item item = new Item(orderFlavorKey, items.get(flavor));
			this.itemRepository.save(item);
		}
		this.sendQuantityUpdates(items);
	}
	
	/*
	 * This method is not a web method as I have no intentions of exposing this
	 * operation to the client. It is only for use here on the backend.
	 */
	public void sendQuantityUpdates(Map<String, Integer> items) {
		final String URI = "/cupcake-service?wsdl";
		StringBuilder entries = new StringBuilder();
		for(String flavor : items.keySet()) {
			entries.append("<entry> <key>" 
					+ flavor + "</key><value>" 
					+ items.get(flavor) 
					+ "</value></entry>");
		}
		final String SOAP_MESSAGE = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.revature.com/\">\r\n"
				+ "   <soapenv:Header/>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <ser:saveAll>\r\n"
				+ "         <arg0>\r\n"
				+ 				entries
				+ "         </arg0>\r\n"
				+ "      </ser:saveAll>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> request = new HttpEntity<>(SOAP_MESSAGE, headers);
		this.restTemplate.postForLocation(URI, request);
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

	@Override
	@WebMethod
	public void sendMessageToBroker(CupcakePurchaseDto message) {
		this.jmsTemplate.convertAndSend(this.simpleMessageTopic, message);
		
	}
	

}
