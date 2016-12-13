package ie.gmit.sw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.*;
import javax.sql.DataSource;


public class DAO{
	
	private DataSource mysqlDS;

	public DAO() throws Exception{
		
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/garage";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	
	// Only Manufacturer is deleted and updated - add is added to everything else
	public void deleteManufacturer(Manufacturer m) throws Exception {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("delete from manufacturer where manu_code = ?");
		myStmt.setString(1, m.getManuCode());
				
		myStmt.executeUpdate();
		
		myStmt.close();
		conn.close();
		
	}
	
	public void updateManufacturer(Manufacturer m) throws SQLException {
		
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Update manufacturer"
				+ " Set manu_name = ?,"
				+ " manu_details = ?"
				+ " where manu_code = ?");
		
		
		myStmt.setString(1, m.getManuName());
		myStmt.setString(2, m.getManuDetails());
		myStmt.setString(3, m.getManuCode());
		myStmt.executeUpdate(); 
		
		myStmt.close();
		conn.close();
	} 

	public void addManufacturer(Manufacturer m) throws SQLException{
		
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT into Manufacturer values(?,?,?)");
		myStmt.setString(1, m.getManuCode());
		myStmt.setString(2, m.getManuName());
		myStmt.setString(3, m.getManuDetails());
		myStmt.executeUpdate();
		
		myStmt.close();
		conn.close();
	}
	
	public ArrayList<Manufacturer> getManufacturer () throws Exception {
		
		ArrayList<Manufacturer> manufacturer = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement ("select * from manufacturer");
		
		ResultSet rs = myStmt.executeQuery();
		
		while(rs.next()){
			
			String manuCode = rs.getString("manu_code");	
			String manuName = rs.getString("manu_name");
			String manuDetails = rs.getString("manu_details");
			manufacturer.add(new Manufacturer(manuCode, manuName, manuDetails));					
		}
		
		return manufacturer;
	}
	
	//========================================================================================================
	
	public void addVehicle(Vehicle v) throws SQLException{
			
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStmt = conn.prepareStatement("INSERT into vehicle values(?,?,?,?,?,?,?)");
			
			myStmt.setString(1, v.getReg());
			myStmt.setString(2, v.getManuCode());
			myStmt.setString(3, v.getModelCode());
			myStmt.setInt(4, v.getMileage());
			myStmt.setDouble(5, v.getPrice());
			myStmt.setString(6, v.getColour());
			myStmt.setString(7, v.getFuel());
			myStmt.executeUpdate();
			
			myStmt.close();
			conn.close();
		}
		
	public ArrayList<Vehicle> getVehicle() throws Exception {
		
		ArrayList<Vehicle> vehicle = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement ("select * from vehicle");
		
		ResultSet rs = myStmt.executeQuery();
		
		while(rs.next()){
			
			String reg = rs.getString("reg");
			String manuCode = rs.getString("manu_code");
			String modelCode = rs.getString("model_code");
			int mileage = rs.getInt("mileage");
			double price = rs.getDouble("price");
			String colour = rs.getString("colour");
			String fuel = rs.getString("fuel");
			
			vehicle.add(new Vehicle(reg, manuCode, modelCode, mileage, price, colour, fuel));
		}
		return vehicle;
	}	
	
	public Vehicle getFullDetails(String d) throws Exception{
		
		Vehicle fullDetails = null;
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select v.*, m.manu_name, m.manu_details, md.model_name, md.model_desc from vehicle v inner join manufacturer m inner join model md where v.manu_code = m.manu_code and v.model_code = md.model_code and reg like ?");
		
		myStmt.setString(1, d);
		ResultSet rs = myStmt.executeQuery();
		
		while(rs.next()){
			
			String reg = rs.getString("reg");
			String manuCode = rs.getString("manu_code");
			String manuName = rs.getString("manu_name");
			String manuDetails = rs.getString("manu_details");
			String modelCode = rs.getString("model_code");
			String modelName = rs.getString("model_name");
			String modelDesc = rs.getString("model_desc");
			int mileage = rs.getInt("mileage");
			double price = rs.getDouble("price");
			String colour = rs.getString("colour");
			String fuel = rs.getString("fuel");
			
			fullDetails = new Vehicle(reg, manuCode, manuName, manuDetails, modelCode, modelName, modelDesc, mileage, price, colour, fuel);
		}
		return fullDetails;		
	}
	
	//========================================================================================================

	public void addModel(Model md) throws SQLException{
			
			Connection conn = mysqlDS.getConnection();
			PreparedStatement myStmt = conn.prepareStatement("INSERT into model values(?,?,?,?)");
			
			myStmt.setString(1, md.getManuCode());
			myStmt.setString(2, md.getModelCode());
			myStmt.setString(3, md.getModelName());
			myStmt.setString(4, md.getModelDesc());
			
			myStmt.executeUpdate();
			myStmt.close();
			conn.close();
		}
		
	public ArrayList<Model> getModel() throws Exception {
		
		ArrayList<Model> model = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement ("select * from model");
		
		ResultSet rs = myStmt.executeQuery();
		
		while(rs.next()){
			
			String manuCode = rs.getString("manu_code");
			String modelCode = rs.getString("model_code");
			String modelName = rs.getString("model_name");
			String modelDesc = rs.getString("model_desc");
			
			model.add(new Model(manuCode, modelCode, modelName, modelDesc));

		}
		return model;
	}
}