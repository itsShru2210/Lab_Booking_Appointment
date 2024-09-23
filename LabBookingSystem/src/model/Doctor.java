package model;


public class Doctor {
	private int dr_id;
    private String dr_name;
    private int dr_no;
   

    // Constructor
    public Doctor(int dr_id,String dr_name,int dr_no)
 {
        this.dr_id = dr_id;
        this.dr_name = dr_name;
        this.dr_no = dr_no;
        
    }

    public Doctor() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public int getDoctor_id() {
        return dr_id;
    }

    public void setDoctor_id(int dr_id) {
        this.dr_id = dr_id;
    }

    public String getDoctor_name() {
        return dr_name;
    }

    public void setDoctor_name(String dr_name) {
        this.dr_name = dr_name;
    }
    
    public int getDoctor_no() {
        return dr_no;
    }

    public void setDoctor_no(int dr_no) {
        this.dr_no = dr_no;
    }
    
   

    @Override
    public String toString() {
        return "doctor{" +
                "dr_id='" + dr_id + '\'' +
                ", dr_name='" + dr_name + '\'' +
                ", dr_no='" + dr_no + '\'' +
              
                '}';
    }

}
