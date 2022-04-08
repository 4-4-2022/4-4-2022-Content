package com.revature.cupcaketest;

import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.revature.model.Cupcake;
/**
 * JUnit is a popular Java testing framework. It allows for easy unit testing of source code with its intuitive annotation-driven approach
 * to testing. As JUnit is a framework, it is responsible for creating instances of our test classs and invoking the methods present on
 * those classes according to those methods' annotations.
 */
import com.revature.service.CupcakeService;

/*
 * This class is going to serve as a test class. We can consider this class, which will be a collection of tests, a "test suite".
 */
@TestInstance(Lifecycle.PER_CLASS)
public class CupcakeServiceTest {

	/*
	 * You can't test a type unless you create an instance of it at some point so that you can call those methods. That said, we are
	 * going to create a CupcakeService at some point during this test suite. We usually call this object our "object under test".
	 */
	private CupcakeService cupcakeService;
	
	/*
	 * Let's see some basic options for setup (setting up my test suite) and teardown (cleaning up after myself by closing any open
	 * connections, etc.) after I have run my tests.
	 */
	
	/*
	 * This method runs a single time (just ONCE) before any tests are run.
	 */
	@BeforeAll
	public void beforeAll() {
		this.cupcakeService = new CupcakeService();
	}
	
	/*
	 * This method runs once per test method that is present on this class. For instance, if there were 3 @Test in this class, this
	 * method would run 3 times.
	 */
	@BeforeEach
	public void beforeEach() {
		
	}
	
	/*
	 * This method denotes an actual test method. Note that this test is being ignored so it will not be run.
	 */
	@Test
	@Disabled
	public void disabledTest() {
		
	}
	
	/*
	 * This tests fails on purpose and I have also included the @Order annotation to show you how to easily order your tests.
	 */
	@Test
	@Order(value = 1)
	public void failedTest() {
		Assertions.fail("not yet implemented");
	}
	
	@Test
	public void testFindByFlavor() {
		/*
		 * If I want to test that the findCupcakeByFlavor method works, I need to call that method. My expectation is that if I type in 
		 * "chocolate cake" that I will get a Set of size 1 and that it will contain a Cupcake with the flavor "Chocolate Cake".
		 */
		Scanner scanner = new Scanner(System.in);
		Set<Cupcake> cupcakes = this.cupcakeService.findCupcakesByFlavor(scanner);
		for(Cupcake c : cupcakes) {
			Assertions.assertEquals("Chocolate Cake", c.getCupcakeFlavor(), "cupcake is NOT chocolate cake after all");
		}
	}
	
	/*
	 * This method runs once per test method that is present on this class. For instance, if there were 3 @Test in this class, this
	 * method would run 3 times. The difference between this and @BeforeEach this would run after each test.
	 */
	@AfterEach
	public void afterEach() {
		
	}
	
	/*
	 * This method runs a single time (just ONCE) after all of the tests are run. This is commonly where you'd see testers closing connections
	 * to mock DBs, etc.
	 */
	@AfterAll
	public void afterAlll() {
		
	}
}
