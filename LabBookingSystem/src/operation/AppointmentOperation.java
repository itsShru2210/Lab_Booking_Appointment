package operation;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;
import java.util.List;

import dao.AppointmetDAO;
import model.Appointme;

public class AppointmentOperation {

    public static void bookAppointmet(Scanner sc) {
        Date appointmentDate = null;
        while (appointmentDate == null) {
            System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
            String appointmentDateStr = sc.nextLine().trim();

            // Validate and parse the appointment date
            try {
                appointmentDate = Date.valueOf(appointmentDateStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        Time appointmentTime = null;
        while (true) {
            System.out.print("Enter Appointment Time (HH:MM:SS) (optional): ");
            String appointmentTimeStr = sc.nextLine().trim();

            if (appointmentTimeStr.isEmpty()) {
                break;
            } else {
                try {
                    appointmentTime = Time.valueOf(appointmentTimeStr);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid time format. Please use HH:MM:SS.");
                }
            }
        }

        // Prompting for Test ID
        System.out.print("Enter Test ID: ");
        int testId = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Prompting for Test Name
        System.out.print("Enter Test Name: ");
        String testName = sc.nextLine().trim();

        // Prompting for Doctor Name
        System.out.print("Enter Doctor Name: ");
        String doctorName = sc.nextLine().trim();

        // Prompting for Doctor Phone Number
        System.out.print("Enter Doctor Phone Number: ");
        String doctorPhone = sc.nextLine().trim();

        // Creating an object of the Appointme class
        Appointme obj = new Appointme(appointmentDate, appointmentTime, testId, testName, doctorName, doctorPhone);

        // Calling method to insert into the table and passing the object of Appointme class
        boolean result = AppointmetDAO.insert(obj);
        if (result) {
            System.out.println("The Appointment is successfully booked.");
        } else {
            System.out.println("Something went wrong.");
        }
    }
    
    public static void viewAppointments() {
        List<Appointme> appointments = AppointmetDAO.getAllAppointments();
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("Appointments:");
            for (Appointme appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
}
