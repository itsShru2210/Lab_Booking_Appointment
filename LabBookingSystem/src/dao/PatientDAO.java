package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.LabDB;
import model.Patient;

public class PatientDAO {
	static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Patient obj) {
        boolean f = false;
        try {
            conn = LabDB.createC();

            String q = "INSERT INTO PATIENTS(p_id,p_name,p_gender, p_age,blood ,addr,email) VALUES (?, ?, ?, ?,?,?,?)";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, obj.getPatientID());
            pstmt.setString(2, obj.getName());
            pstmt.setString(3, obj.getGender());
            pstmt.setInt(4, obj.getage());
            pstmt.setString(5, obj.getBlood());
            pstmt.setString(6, obj.getAdd());
            
           
            pstmt.setString(7, obj.getEmail());

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

    // Update Instructor
    public static boolean update(Patient obj, int p_id) {
        boolean f = false;
        try {
            conn = LabDB.createC();

            String q = "UPDATE PATIENTS SET p_name = ?, p_gender= ?, p_age = ?,blood=?,addr=?,email=? WHERE p_id = ?";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, obj.getPatientID());
            pstmt.setString(2, obj.getName());
            pstmt.setString(3, obj.getGender());
            pstmt.setInt(4, obj.getage());
            pstmt.setString(5, obj.getBlood());
            pstmt.setString(6, obj.getAdd());
   pstmt.setString(7, obj.getEmail());

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    

    // 
    public static Patient getByPatientID(String p_id) {
        Patient patient = null;
        try {
            conn = LabDB.createC();

            String q = "SELECT * FROM PATIENTS WHERE p_id=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, p_id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                patient = new Patient();
                patient.setPatientID(rs.getInt("p_id"));
                patient.setName(rs.getString("p_name"));
                patient.setGender(rs.getString("p_gender"));
               
                patient.setage(rs.getInt("p_age"));
                patient.setBlood(rs.getString("blood"));
                patient.setAdd(rs.getString("addr"));
                patient.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return patient;
    }

    public static List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            conn =LabDB.createC();

            String q = "SELECT * FROM PATIENTS";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientID(rs.getInt("p_id"));
                patient.setName(rs.getString("p_name"));
                patient.setGender(rs.getString("p_gender"));
               
                patient.setage(rs.getInt("p_age"));
                patient.setBlood(rs.getString("blood"));
                patient.setAdd(rs.getString("addr"));
                patient.setEmail(rs.getString("email"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return patients;
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
