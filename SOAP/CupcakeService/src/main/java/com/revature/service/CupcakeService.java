package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.model.Cupcake;

/*
 * This defines this interface as one that implements a web service. This interface is a service endpoint interface (SEI),
 * which means that it declares methdos that a client can invoke on this web service. Note that SEIs are not required
 * when building a Jax-@S endpoint because webservice implementation classes implicitly define SEIs.
 * 
 * This SEI is used determine the abstract WSDL contract.
 * 
 * As a reminder, if a method isn't declared on this interface, it is not going to show up in the WSDL.
 */

@WebService
public interface CupcakeService {

	public List<Cupcake> findAll();
	public void save(Cupcake cupcake);
	public void receiveMessage(String message);
}
