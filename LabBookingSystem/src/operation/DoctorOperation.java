package operation;

import java.util.List;
import java.util.Scanner;

import dao.DoctorDAO;
import model.Doctor;

public class DoctorOperation {
	public static void addDoctor(Scanner sc) {
		System.out.println("Enter Doctor ID:");
        int dr_id = sc.nextInt();

        System.out.println("Enter Doctor Name:");
        String dr_name = sc.next();
        sc.nextLine();
        System.out.println("Enter Doctor Phone No:");
        int dr_no = sc.nextInt();

       
        
        
        // Creating object of Course class
        Doctor obj = new Doctor( dr_id,dr_name,dr_no);

        // Calling method to insert into table and passing the object of Movie class
        boolean result = DoctorDAO.insert(obj);
        if (result) {
            System.out.println(" The Doctor is successfully added.");
            System.out.println("To continue follow the steps...");
        } else {
            System.out.println("Something went wrong.");
        }
	}
	 public static void deleteDoctorById(Scanner sc) {
	    	System.out.println("Enter Doctor id to delete:");
	        int dr_id = sc.nextInt();

	        // Calling method to delete a particular row
	        boolean result = DoctorDAO.delete(dr_id);
	        if (result) {
	            System.out.println("The Doctor is successfully deleted.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }

    public static void showDoctors(Scanner sc) {
    	//Get all Course
    	List<Doctor> doctors = DoctorDAO.getAllDoctor();
        for (Doctor doctor : doctors) {
        	System.out.println(doctor);
        }
    }
    
    
    
   
}
