package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

            String q = "INSERT INTO appointment1 (appointmentDate, appointmentTime, testId, testName, doctorName, doctorPhone) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

            pstmt.setDate(1, obj.getAppointmentDate());
            pstmt.setTime(2, obj.getAppointmentTime());
            pstmt.setInt(3, obj.getTestId());
            pstmt.setString(4, obj.getTestName());
            pstmt.setString(5, obj.getDoctorName());
            pstmt.setString(6, obj.getDoctorPhone());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                // Handle the auto-generated key if required
            }

            f = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    // Method to retrieve all appointments
    public static List<Appointme> getAllAppointments() {
        List<Appointme> appointments = new ArrayList<>();
        try {
            conn = LabDB.createC();

            String q = "SELECT * FROM appointment1";
            pstmt = conn.prepareStatement(q);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // Create an Appointme object for each row
                Appointme appointment = new Appointme();
                appointment.setAppointmentDate(rs.getDate("appointmentDate"));
                appointment.setAppointmentTime(rs.getTime("appointmentTime"));
                appointment.setTestId(rs.getInt("testId"));
                appointment.setTestName(rs.getString("testName"));
                appointment.setDoctorName(rs.getString("doctorName")); // Added
                appointment.setDoctorPhone(rs.getString("doctorPhone")); // Added
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return appointments;
    }

    // Close resources to avoid memory leaks
    private static void closeResources() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to close resources: " + e.getMessage());
        }
    }
}
