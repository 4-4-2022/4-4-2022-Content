package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.revature.client.ClientDriver;

/*
 * We ONLY need to implement this CommandLineRunner interface because we are building a console
 * app.
 */
@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner{

	@Autowired
	private ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	
	/*
	 * When you implement the CommandLineRunner interface, you have to override the "run" method.
	 */
	@Override
	public void run(String... args) throws Exception {
	
		ClientDriver driver = this.context.getBean("client", ClientDriver.class);
		driver.startApp();
	}
	
	

}
