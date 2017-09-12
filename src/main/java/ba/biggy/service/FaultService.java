package ba.biggy.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ba.biggy.global.Constants;
import ba.biggy.model.Fault;
import ba.biggy.utility.DBUtility;

public class FaultService {
	
private Connection connection;
	
	public FaultService() {
		connection = DBUtility.getConnection();
	}
	
	
	
	
	
	public List<Fault> getFaults(){
		
		List<Fault> faults = new ArrayList<Fault>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + Constants.TABLE_FAULTS + " WHERE " + Constants.STATUS_COLUMN + " = '"+ Constants.FAULT_STATUS_TO_DO +"'");
			
			while (rs.next()) {
				Fault fault = new Fault();
				fault.setClient(rs.getString("Buyer"));
				
				faults.add(fault);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return faults;
	}

}
