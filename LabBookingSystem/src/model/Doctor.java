package model;

public class Doctor {
    private int dr_id;
    private String dr_name;
    private String dr_no; // Changed to String to accommodate phone numbers

    // Constructor
    public Doctor(int dr_id, String dr_name, String dr_no) {
        this.dr_id = dr_id;
        this.dr_name = dr_name;
        this.dr_no = dr_no;
    }

    public Doctor() {
        // Default constructor
    }

    // Getters and setters
    public int getDrId() {
        return dr_id;
    }

    public void setDrId(int dr_id) {
        this.dr_id = dr_id;
    }

    public String getDrName() {
        return dr_name;
    }

    public void setDrName(String dr_name) {
        this.dr_name = dr_name;
    }

    public String getDrNo() {
        return dr_no;
    }

    public void setDrNo(String dr_no) {
        this.dr_no = dr_no;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "dr_id=" + dr_id +
                ", dr_name='" + dr_name + '\'' +
                ", dr_no='" + dr_no + '\'' +
                '}';
    }
}
