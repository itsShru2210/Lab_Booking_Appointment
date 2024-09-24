package model;

import java.sql.Date;
import java.sql.Time;

public class Appointme {
    private Date appointmentDate;
    private Time appointmentTime;
    private int testId;
    private String testName;
    private String doctorName; // Added
    private String doctorPhone; // Added

    // Constructor with parameters
    public Appointme(Date appointmentDate, Time appointmentTime, int testId, String testName, String doctorName, String doctorPhone) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.testId = testId;
        this.testName = testName;
        this.doctorName = doctorName; // Added
        this.doctorPhone = doctorPhone; // Added
    }

    // Default constructor
    public Appointme() {
        // Default constructor logic if needed
    }

    // Getters and setters
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public int getTestId() {
        return testId; // Added
    }

    public void setTestId(int testId) {
        this.testId = testId; // Added
    }

    public String getTestName() {
        return testName; // Added
    }

    public void setTestName(String testName) {
        this.testName = testName; // Added
    }

    public String getDoctorName() { // Added
        return doctorName;
    }

    public void setDoctorName(String doctorName) { // Added
        this.doctorName = doctorName;
    }

    public String getDoctorPhone() { // Added
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) { // Added
        this.doctorPhone = doctorPhone;
    }

    @Override
    public String toString() {
        return "Appointme{" +
                "appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", testId=" + testId +
                ", testName='" + testName + '\'' +
                ", doctorName='" + doctorName + '\'' + // Added
                ", doctorPhone='" + doctorPhone + '\'' + // Added
                '}';
    }
}
