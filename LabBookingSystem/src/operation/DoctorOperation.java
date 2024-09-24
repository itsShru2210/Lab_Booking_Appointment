package operation;

import java.util.List;
import java.util.Scanner;

import dao.DoctorDAO;
import model.Doctor;

public class DoctorOperation {

    public static void addDoctor(Scanner sc) {
        System.out.println("Enter Doctor ID:");
        int dr_id = sc.nextInt();
        sc.nextLine(); // Consume newline left-over

        System.out.println("Enter Doctor Name:");
        String dr_name = sc.nextLine(); // Changed to nextLine() to capture full name

        System.out.println("Enter Doctor Phone No:");
        String dr_no = sc.nextLine(); // Changed to String to avoid InputMismatchException

        // Creating an object of the Doctor class
        Doctor obj = new Doctor(dr_id, dr_name, dr_no); // Updated constructor call

        // Calling method to insert into table and passing the object of Doctor class
        boolean result = DoctorDAO.insert(obj);
        if (result) {
            System.out.println("The Doctor is successfully added.");
            System.out.println("To continue, follow the steps...");
        } else {
            System.out.println("Something went wrong.");
        }
    }

    public static void deleteDoctorById(Scanner sc) {
        System.out.println("Enter Doctor ID to delete:");
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
        // Get all Doctors
        List<Doctor> doctors = DoctorDAO.getAllDoctors(); // Updated method name to getAllDoctors
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }
}
