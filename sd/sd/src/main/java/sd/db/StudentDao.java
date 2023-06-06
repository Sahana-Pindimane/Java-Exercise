package sd.db;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


	public class StudentDao {
	    private static final String ROLL_NUMBER_TABLE = "roll_number";
	    private static final String ROLL_NUMBER_COL = "last_roll_number";

	    static Connection con = JDBCConnection.getConnection();

	    public static String add(Student student) throws SQLException {
	        String query = "INSERT INTO student(name, address, be_branch, reg_number) VALUES (?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(query);
	        
	        // Generate a unique 3-digit roll number
	        String rollNumber = generateRollNumber();
	        
	        ps.setString(1, student.getName());
	        ps.setString(2, student.getAddress());
	        ps.setString(3, student.getBEBranch());
	        ps.setString(4, rollNumber);
	        
	        ps.executeUpdate();
	        
	        return rollNumber;
	    }

	    @SuppressWarnings("resource")
		private static String generateRollNumber() throws SQLException {
	        String rollNumber = "";
	        
	        // Get the last assigned roll number from the database
	        String query = "SELECT " + ROLL_NUMBER_COL + " FROM " + ROLL_NUMBER_TABLE;
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            int lastRollNumber = rs.getInt(ROLL_NUMBER_COL);
	            lastRollNumber++;
	            
	            // Generate a 3-digit roll number by padding zeros if necessary
	            rollNumber = "2022MAHE"+String.format("%03d", lastRollNumber);
	            
	            // Update the roll number table with the new last assigned roll number
	            query = "UPDATE " + ROLL_NUMBER_TABLE + " SET " + ROLL_NUMBER_COL + " = ?";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, lastRollNumber);
	            ps.executeUpdate();
	        } else {
	            // The roll number table is empty, insert a new row with the initial value of 1
	            query = "INSERT INTO " + ROLL_NUMBER_TABLE + "(" + ROLL_NUMBER_COL + ") VALUES (?)";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, 1);
	            ps.executeUpdate();
	            
	            // The first roll number will be "001"
	            rollNumber = "2022MAHE001";
	        }
	        
	        return rollNumber;
	    }
	}

