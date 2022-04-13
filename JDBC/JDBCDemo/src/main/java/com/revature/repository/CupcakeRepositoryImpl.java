package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.model.Cupcake;
import com.revature.util.ConnectionFactory;
import com.revature.util.ResourceCloser;

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
			while(set.next()) {
				cupcakes.add(new Cupcake(
						set.getString(1),
						set.getFloat(2),
						set.getInt(3),
						set.getInt(4),
						set.getBoolean(5),
						set.getBoolean(6)
					));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
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

	@Override
	public void save(Cupcake cupcake) {
		/*
		 * You always needs a connection to a DB before you begin transaction.
		 */
		Connection conn = null;
		/*
		 * Of course we'll need to be able to write a query, so we'll need a Statement.
		 * Note that we have changed this to a PreparedStatement. PreparedStatement is designed
		 * to prevent SQL Injection. SQL injection occurs when an end user write SQL in a field
		 * that then gets to sent to your database and executed.
		 * 
		 * A PreparedStatement precompiles the SQL query and uses typed placeholders for the information
		 * that will be passed to the DB. Because the queries are pre-compiled, they're faster.
		 * 
		 * Note that our SQL statement is parameterized. We need to pass in values for each
		 * parameter at some point.
		 */
		PreparedStatement stmt = null;
		final String SQL = "insert into cupcake values(?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, cupcake.getCupcakeFlavor());
			stmt.setFloat(2, cupcake.getCost());
			stmt.setInt(3, cupcake.getBakery());
			stmt.setInt(4, cupcake.getCalories());
			stmt.setBoolean(5, cupcake.isGlutenFree());
			stmt.setBoolean(6, cupcake.isVegan());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
		
	}

	@Override
	public void update(Cupcake cupcake) {
		
	}

	@Override
	public void delete(Cupcake cupcake) {
		// TODO Auto-generated method stub
		
	}
}
