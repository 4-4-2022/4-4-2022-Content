package com.revature.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import com.revature.repository.CupcakeRepository;
import com.revature.repository.CupcakeRepositoryImpl;
import com.revature.service.CupcakeService;

/*
 * You can add beans to your IOC container using a more class-based approach. This entails creating a configuration
 * class and using Spring annotations rather than using an XML file. If you are using a class to configure the beans
 * in your IOC container, you should mark that class as a @Configuration class.
 * 
 * You also have to tell Spring which packages to scan for annotated types using the @ComponentScan annotation.
 */

@Configuration
@ComponentScan(basePackages = {"com.revature.repository", "com.revature.service", "com.revature.util"})
@EnableAspectJAutoProxy
public class AppConfig {

	/*
	 * We can also add beans to the container using the @Bean annotation inside of a @Configuration class.
	 * You simply create a method that is annotated with @Bean. This method should return your bean which will then
	 * be placed in the IOC container. Note that you typically see this approach for highly configurable types.
	 */
	
	@Bean
	public CupcakeService cupcakeService2() {
		/*
		 * Note that it is common to see bean methods being called to supply dependencies inside of other bean
		 * methods.
		 */
		return new CupcakeService(cupcakeRepository());
		
	}
	
	@Bean(name = "cupcakeRepository2")
	@Scope("singleton")
	public CupcakeRepository cupcakeRepository() {
		return new CupcakeRepositoryImpl();
	}
}
