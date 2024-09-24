package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import connection.LabDB;
import model.Labortories;

public class LaboratoriesDAO {

	   static PreparedStatement pstmt = null;
	    static Connection conn = null;
	    static Statement stmt = null;
	    static ResultSet rs = null;

	    // Insert method handles auto-increment
	    public static boolean insert(Labortories obj) {
	        boolean f = false;
	        try {
	            conn = LabDB.createC();

	            String q = "insert into TestDetails (tid,testName,price) VALUES (?,?, ?)";
	            pstmt = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
	            pstmt.setInt(1, obj.gettid());
	            pstmt.setString(2, obj.getTestName());
	            pstmt.setInt(3, obj.getCost());
	           

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

	  
	    // Delete Method
	    public static boolean delete(String testName) {
	        boolean f = false;
	        try {
	            conn = LabDB.createC();

	            String qDelete = "DELETE FROM TestDetails WHERE testName=?"; // Correct SQL query with 1 placeholder
	            pstmt = conn.prepareStatement(qDelete);
	            pstmt.setString(1, testName); // Change index from 2 to 1

	            pstmt.executeUpdate();
	            f = true;

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return f;
	    }


	    
	    public static List<Labortories> getAlllabs() {
	        List<Labortories> labortoriess = new ArrayList<>();
	        try {
	            conn = LabDB.createC();

	            String q = "select *from TestDetails";
	            stmt = conn.createStatement();

	            rs = stmt.executeQuery(q);

	            while (rs.next()) {
	            	Labortories labortories = new Labortories();
	            	labortories.settid(rs.getInt("tid"));
	            	labortories.setTestName(rs.getString("testName"));
	            	labortories.setCost(rs.getInt("price"));
	            	labortoriess.add(labortories);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return labortoriess;
	    }

	    // Close resources method
	    private static void closeResources() {
	        try {
	            if (pstmt != null)
	                pstmt.close();
	            if (rs != null)
	                rs.close();
	            if (conn != null)
	                conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
