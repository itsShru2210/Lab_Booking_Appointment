package operation;

import java.util.Scanner;

import dao.AppointmetDAO;
import model.Appointme;

public class AppointmentOperation {
	public static void bookAppointmet(Scanner sc) {
		System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
		
		String appointmentDate = sc.nextLine();
		
       // java.sql.Date appointmentDate = java.sql.Date.valueOf(appointmentDateStr);

        System.out.print("Enter Appointment Time (HH:MM:SS) (optional): ");
        String appointmentTime = sc.nextLine();

        
        // Creating object of Student class
        Appointme obj = new Appointme(appointmentDate,appointmentTime);

        // Calling method to insert into table and passing the object of Student class
        boolean result =AppointmetDAO.insert(obj);
        if (result) {
            System.out.println("The Appointmet is successfully Booked.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

}
