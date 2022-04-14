package com.revature.cupcaketest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.model.Cupcake;
import com.revature.repository.CupcakeRepository;
import com.revature.service.CupcakeService;

import uk.org.webcompere.systemstubs.SystemStubs;

/*
 * Remember that JUnit is a popular Java unit testing framework. It's easy to use as it is
 * annotation-driven and it actually creates instances of our test classes and invokes all of
 * our tests. The annotations give you a fair bit of control over test setup and teardown.
 */

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class CupcakeServiceTest {

	//Our CupcakeService is our object under test.
	@InjectMocks
	private CupcakeService cupcakeService;
	/*
	 * This is not our object under test; we're not testing it at all. That said, our CupcakeService
	 * has a CupcakeRepository property that leads to us transitively calling CupcakeRepository methods.
	 * This muddies our test results as invoking multiple methods during a test makes it hard to identify
	 * the source of a bug. That said, we can mock the CupcakeRepository and inject this mock into
	 * our object under test. A mock's real methods will NOT be called.
	 */
	@Mock
	private CupcakeRepository cupcakeRepository;
	/*
	 * I'm defined a mock Set of cupcakes for use throughout this test class.
	 */
	private Set<Cupcake> mockCupcakes;
	
	
	/*
	 * We're just doing basic setup before running any tests. Can't test the CupcakeService if
	 * you don't have an instance of it after all.
	 */
	@BeforeAll
	public void setup() {
		/*
		 * Yes, Mockito is annotation-driven, but you do have to tell it to initialize mocks
		 * based on your above annotations.
		 */
		MockitoAnnotations.openMocks(this);
		this.cupcakeService = new CupcakeService();
		this.mockCupcakes = new HashSet<>();
		this.mockCupcakes.add(new Cupcake("Champagne", 3.45f, 1, 100, true, true));
		this.mockCupcakes.add(new Cupcake("Vanilla", 5.40f, 2, 1000, false, true));
		this.mockCupcakes.add(new Cupcake("Birthday", 13.00f, 1, 350, true, false));
	}
	
	/*
	 * This test is a bad unit test. It completely relies on there being a certain number of 
	 * records in my DB. This means the test would fail if that number of records ever changed.
	 * This is a flakey test.
	 * 
	 * Another issue is that this test is testing more than just the findAllCupcakes method. We're
	 * actually hitting a database.
	 * 
	 * Lastly, we should not be using production data for testing.
	 * 
	 * We can easily solve this problem by using a mocking framework (Mockito in our case) in order
	 * to stub the results of our method calls. A "stub" is a canned (predetermined) result. Using
	 * Mockito in this way gives us greater control over isolating bugs as we more greatly narrow
	 * down where a bug is in our application.
	 */
	@Test
	@Disabled
	public void testFindAllCupcakesBadly() {
		Set<Cupcake> cupcakes = this.cupcakeService.findAllCupcakes();
		Assertions.assertEquals(4, cupcakes.size());
	}
	
	@Test
	public void testFindAllCupcakes() {
		/*
		 * We must specify what should happen when any CupcakeRepository methods are called.
		 * We have specified that when our CupcakeRepository findAllCupcakes method is called,
		 * it should return our mockCupcakes.
		 */
		Mockito.when(this.cupcakeRepository.findAllCupcakes()).thenReturn(this.mockCupcakes);
		Set<Cupcake> cupcakes = this.cupcakeService.findAllCupcakes();
		Assertions.assertEquals(3, cupcakes.size());
	}
	
	/*
	 * The point of the takeCupcakeInfo method is to take the user's input, parse it (in our case
	 * by splitting the input around commas), and returning that input as a String[].
	 */
	@Test
	public void testTakeCupcakeInfo() throws Exception{
		/*
		 * The SystemStubs extension for JUnit allows us to stub system calls. The System class
		 * can be used to access environment variables, the std input stream, std output stream, etc.
		 * That said, use of the System class leaves your application dependent on the environment in
		 * which the application itself runs. Unit tests, however, should not really on external
		 * factors such as environment configuration. They should rely on just the source code itself.
		 * 
		 * Fortunately, the SystemStubs extension makes it easy to stub those system calls. We just
		 * need to be familiar with lambda syntax.
		 */
		SystemStubs.withTextFromSystemIn("chocolate, strawberry,vanilla").execute(() -> {
			Scanner scanner = new Scanner(System.in);
			String[] flavors = this.cupcakeService.takeCupcakeInfo(scanner);
			Assertions.assertEquals("chocolate", flavors[0]);
			Assertions.assertEquals("strawberry", flavors[1]); //this makes my test fail
			Assertions.assertEquals(3, flavors.length);
		});
	}
	
}
