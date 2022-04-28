package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Cupcake;
import com.revature.service.CupcakeService;

/*
 * In Spring, a controller is used to handle incoming HTTP requests. Spring's built-in DispatcherServlet consults
 * the HandlerMapping interface to decide which controller should handle a specific request by using the controller's
 * mapping URL.
 * 
 * A RestController is a specialization of a Controller that specifically writes to the HTTP response body. The default
 * Controller is used to return views/templates to the client, but as we're not building frontends, we don't need this
 * functionality.
 */
@RestController("cupcakeController")
@RequestMapping("/cupcake")
public class CupcakeController {
	
	private CupcakeService cupcakeService;
	
	@Autowired
	public void setCupcakeService(CupcakeService cupcakeService) {
		this.cupcakeService = cupcakeService;
	}

	/*
	 * You can always use @RequestMapping, but using a specialty annotation such as @GetMapping or @PostMapping
	 * is more concise. I've also included the "produces" attribute here; it specifies that this endpoint "/all"
	 * returns JSON to the client. Of course, there are several other media types such as XML and even plain text!
	 */
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cupcake>> findAll(){
		ResponseEntity<List<Cupcake>> httpResponse 
						= new ResponseEntity<>(this.cupcakeService.findAll(), HttpStatus.OK);
		return httpResponse;
	}
	
	/*
	 * The "consumes" attribute specifies that this resource, which only accepts POST requests, only allows the client
	 * to send JSON to the server.
	 */
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	/*
	 * The @RequestBody annotation tells Spring to take whatever is sent in the HTTP request body and immediately marshall
	 * that data into a Cupcake object. Note that if the value that is sent from the client is malformed, this marshalling
	 * will not work properly. For instance, you can't send JSON that represents a bakery and try to marshall that data into
	 * a Cupcake.
	 */
	public void save(@RequestBody Cupcake cupcake) {
		this.cupcakeService.save(cupcake);
	}
	
	/*
	 * Using a path variable allows us to pass information back as a part of the URL.
	 */
	@GetMapping("/{flavor}")
	public Cupcake findCupcakeByFlavor(@PathVariable String flavor) {
		return this.cupcakeService.findByCupcakeFlavor(flavor);
	}
	
	/*
	 * Using request parameters allows us to grab the query string and immediately parse the values. For instance:
	 * http:/localhost:8082/cupcake/cost?cost1=2&cost2=15 has a query string of "?cost1=2&cost2=15". These are
	 * key-value pairs that are sent to the server as a map. We can isolate these pairs to access the underlying 
	 * values on the backend.
	 */
	@GetMapping("/cost")
	public List<Cupcake> findAllByCostBetween(@RequestParam float cost1, @RequestParam float cost2){
		return this.cupcakeService.findAllByCostBetween(cost1, cost2);
	}
}
