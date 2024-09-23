package model;

//import java.util.Date;

public class Appointme {
	
    private String appointmentTime;
    private String  appointmentDate;
   

    // Constructor
    public Appointme(String appointmentDate ,String appointmentTime) {
        this. appointmentDate=  appointmentDate;
      
        this.appointmentTime =appointmentTime;
       
    }

    public Appointme() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public String getappointmentDate() {
        return appointmentDate;
    }

    public void setappointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

   

    public String getappointmentTime() {
        return appointmentTime;
    }

    public void setappointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

   

   

   

    

    @Override
    public String toString() {
        return "Appontme{" +
                "appointmentDate='" +appointmentDate + '\'' +
                ", appointmentTime ='" + appointmentTime  + '\'' +
               
                '}';
    }

}
