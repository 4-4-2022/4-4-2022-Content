package com.revature.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Cupcake;
import com.revature.repository.CupcakeRepository;

/*
 * This class is an implementation of our CupcakeService interface. This class is building out the functionality
 * for our service endpoint.
 */
@WebService(endpointInterface = "com.revature.service.CupcakeService", name = "cupcake")
public class CupcakeServiceImpl implements CupcakeService{
	
	private CupcakeRepository cupcakeRepository;
	
	
	public CupcakeServiceImpl() {}
	
	public CupcakeServiceImpl(CupcakeRepository cupcakeRepository) {
		this.cupcakeRepository = cupcakeRepository;
	}
	
	@Autowired
	public void setCupcakeRepository(CupcakeRepository cupcakeRepository) {
		this.cupcakeRepository = cupcakeRepository;
	}
	
	/**
	 * If you are using variable arguments, the var-arg MUST be the last parameter. This implies that there can only be one var-arg.
	 * @param flavors
	 * @return a Set of type Cupcake
	 */
	public Cupcake findByFlavor(String flavor){
		return this.cupcakeRepository.findByCupcakeFlavor(flavor);
	}
	
	/*
	 * This annotation exposes this method as a web service operation.
	 */
	@WebMethod
	public List<Cupcake> findAll(){
		return this.cupcakeRepository.findAll();
	}
	
	@WebMethod
	public void save(Cupcake cupcake) {
		this.cupcakeRepository.save(cupcake);
	}

	@Override
	@WebMethod
	public void receiveMessage(String message) {
		System.out.println(message);
		
	}

	@Override
	@WebMethod
	public void saveAll(Map<String, Integer> items) {
		List<Cupcake> cupcakesToUpdate = this.cupcakeRepository.findAllById(items.keySet());
		System.out.println(cupcakesToUpdate);
		for(String flavor : items.keySet()) {
			for(Cupcake cupcake : cupcakesToUpdate) {
				if(cupcake.getCupcakeFlavor().equals(flavor)) {
					cupcake.setStock(cupcake.getStock() - items.get(flavor));
				}
			}
		}
		this.cupcakeRepository.saveAll(cupcakesToUpdate);
	}
}
