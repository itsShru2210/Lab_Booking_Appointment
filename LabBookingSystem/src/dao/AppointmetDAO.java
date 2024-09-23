package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Time;


import connection.LabDB;
import model.Appointme;

public class AppointmetDAO {
	 static PreparedStatement pstmt = null;
	    static Connection conn = null;
	    static Statement stmt = null;
	    static ResultSet rs = null;

	    // Insert method handles auto-increment
	    public static boolean insert(Appointme obj) {
	        boolean f = false;
	        try {
	            conn = LabDB.createC();

	            String q = "insert into appointment1(appointmentDate,appointmentTime) values (?,  ?)";
	            pstmt = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

	            pstmt.setString(1, obj.getappointmentDate());
	            pstmt.setString(2, obj.getappointmentTime());
	            
	         

	            pstmt.executeUpdate();

	            // Retrieve the auto-generated key (ID)
	            ResultSet rs = pstmt.getGeneratedKeys();
	            if (rs.next()) {
	                // You might want to handle the auto-generated key if required
	            }

	            f = true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            closeResources();
	        }
	        return f;
	    }

		private static void closeResources() {
			// TODO Auto-generated method stub
			
		}


		


}
