package model;

public class Patient {
	private int p_id;
    private String p_name;
    private String p_gender;
   
    private int p_age;
    private String blood;
    private String addr;
    private String email;
    
    
    
    

    // Constructor
    public Patient(int p_id,String p_name,String p_gender, int p_age,String blood,String addr,String email) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_gender = p_gender;
       
        this.p_age = p_age;
        this.blood = blood;
        this.addr = addr;
        this.email = email;
    }

    public Patient() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public int getPatientID() {
        return p_id;
    }

    public void setPatientID(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return p_name;
    }

    public void setName(String p_name) {
        this.p_name = p_name;
    }

    public String getGender() {
        return p_gender;
    }

    public void setGender(String p_gender) {
        this.p_gender = p_gender;
    }
   
    public int getage() {
        return p_age;
    }

    public void setage(int p_age) {
        this.p_age = p_age;
    }
    
    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood= blood;
    }

    public String getAdd() {
        return addr;
    }

    public void setAdd(String add) {
        this.addr = add;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "p_id='" + p_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", p_gender='" +  p_gender + '\'' +
                
                ", p_age='" +p_age + '\'' +
                ",blood='" +blood + '\'' +
                ", addr='" + addr + '\'' +
                 ", email='" +email + '\'' +
                '}';
    }

	

}
