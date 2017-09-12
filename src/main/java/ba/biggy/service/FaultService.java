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
	
	
	
	
	
	public List<Fault> listToDoFaults(){
		
		List<Fault> faults = new ArrayList<Fault>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + Constants.TABLE_FAULTS + " WHERE " + Constants.STATUS_COLUMN + " = '"+ Constants.FAULT_STATUS_TO_DO +"'");
			
			while (rs.next()) {
				Fault fault = new Fault();

				fault.setId(rs.getInt(Constants.ID_COLUMN));
	            fault.setDate(rs.getString(Constants.DATE_COLUMN));
	            fault.setTime(rs.getString(Constants.TIME_COLUMN));
	            fault.setIdent(rs.getString(Constants.IDENT_COLUMN));
	            fault.setClient(rs.getString(Constants.CLIENT_COLUMN));
	            fault.setStreet(rs.getString(Constants.STREET_COLUMN));
	            fault.setPlace(rs.getString(Constants.PLACE_COLUMN));
	            fault.setPhoneOne(rs.getString(Constants.PHONE_ONE_COLUMN));
	            fault.setPhoneTwo(rs.getString(Constants.PHONE_TWO_COLUMN));
	            fault.setFaultDescription(rs.getString(Constants.FAULT_DESCRIPTION_COLUMN));
	            fault.setNote(rs.getString(Constants.NOTE_COLUMN));
	            fault.setServiceman(rs.getString(Constants.SERVICEMAN_COLUMN));
	            fault.setTypeOfService(rs.getString(Constants.TYPE_OF_SERVICE_COLUMN));
				
				faults.add(fault);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return faults;
	}

}
