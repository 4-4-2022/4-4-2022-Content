package com.revature.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.model.Cupcake;
import com.revature.util.ConnectionFactory;

/*
 * This Cupcake repository is my source of data concerning "records" of the cupcakes we have
 * in stock. Now we can connect to our database using JDBC, so the records are actually coming
 * from the database. 
 * 
 * Note that this type of class is called a Data Access Object (DAO). This class is dedicated entirely
 * to accessing data from a data source (my database in this case). Note that this is just a design
 * pattern.
 * 
 * This class has also been modified so that it is a Singleton.
 */
public class CupcakeRepositoryImpl implements CupcakeRepository{
	
	private static CupcakeRepositoryImpl cupcakeRepository;
	public static int counter;
	
	
	/*We're using this constructor to initialize some of the mock cupcakes. For the sake of turning this class into a Singleton, we have
	 * made the constructor private so that instances cannot be freely created throughout the application.
	 */
	
	private CupcakeRepositoryImpl() {
		counter++;
	}
	
	/*
	 * When building a Singleton, it is typical to see a method that returns the single instance of this type to the caller. We create the
	 * single instance within the context of this class and return that same instance to the caller every single time this method is called.
	 * 
	 * We've added the synchronized keyword here in order to prevent multiple instances of this type from being from created in a
	 * multi-threaded environment (as in our demo earlier). Yes, synchronization makes the program slower, but it prevents us from
	 * our breaking our design pattern.
	 */
	public static synchronized CupcakeRepositoryImpl getCupcakeRepository() {
		if(cupcakeRepository == null) {
			cupcakeRepository = new CupcakeRepositoryImpl();
		}
		return cupcakeRepository;
	}
	
	public Set<Cupcake> findAllCupcakes() {
		
		Set<Cupcake> cupcakes = new HashSet<>();
		
		/*
		 * Please note that the JDBC workflow is standard; you'll often find yourself writing
		 * similar code.
		 * 
		 * A workflow always requires a Connection. It will also require a Statement (interface).
		 * The Statement interface represents a SQL statement that can be executed against your
		 * DB.
		 * 
		 * Sometimes, a workflow will require a ResultSet (interface). Your ResultSet represents
		 * the records that are returned after executing a query.
		 */
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from cupcake";
		
		try {
			/*
			 * We made a utility method that puts in our DB credentials and returns a new connection
			 * to us.
			 */
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			//At this point, we have executed a statement and we have the records.
			set = stmt.executeQuery(SQL);
			System.out.println(set);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			conn.close();
			stmt.close();
			set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cupcakes;
	}

	/**
	 * This method iterates over our repository of cupcakes and finds the cupcake of a specific flavor.
	 * 
	 * @param flavor the flavor of the cupcake that should be returned
	 */
	@Override
	public Cupcake findCupcakeByFlavor(String flavor) {
		
		return null;
	}
	
	@Override
	public Set<Cupcake> findCupcakesByFlavor(String...flavors) {
		return null;
	}
}
