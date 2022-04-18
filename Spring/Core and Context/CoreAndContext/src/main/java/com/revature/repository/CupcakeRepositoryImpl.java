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

public class CupcakeRepositoryImpl implements CupcakeRepository{
	
	
	public CupcakeRepositoryImpl() {
	}
	
	public Set<Cupcake> findAllCupcakes() {
		
		Set<Cupcake> cupcakes = new HashSet<>();
		
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
