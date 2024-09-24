package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.LabDB;
import model.Doctor;

public class DoctorDAO {

    static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Doctor obj) {
        boolean f = false;
        try {
            conn = LabDB.createC();

            String q = "INSERT INTO DOCTOR(dr_id, dr_name, dr_no) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, obj.getDrId()); // Updated to match the getter method
            pstmt.setString(2, obj.getDrName()); // Updated to match the getter method
            pstmt.setString(3, obj.getDrNo()); // Changed to setString for phone number
            
            pstmt.executeUpdate();
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
    public static boolean delete(int dr_id) {
        boolean f = false;
        try {
            conn = LabDB.createC();

            String qDelete = "DELETE FROM DOCTOR WHERE dr_id=?";
            pstmt = conn.prepareStatement(qDelete);
            pstmt.setInt(1, dr_id);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    public static List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try {
            conn = LabDB.createC();

            String q = "SELECT * FROM DOCTOR";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDrId(rs.getInt("dr_id")); // Updated to match the getter method
                doctor.setDrName(rs.getString("dr_name")); // Updated to match the getter method
                doctor.setDrNo(rs.getString("dr_no")); // Changed to setString for phone number
                
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return doctors;
    }

    // Close resources method
    private static void closeResources() {
        try {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
