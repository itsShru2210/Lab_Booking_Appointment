package menu;

import java.util.Scanner;

import operation.PatientsOperation;
import operation.DoctorOperation;
import operation.LaboratorieOperation;
import operation.AppointmentOperation;



public class UserMenu {


    // Doctor menu
    public static void userMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\nWelcome to User Page\n");
            System.out.println("1.Manage Details");
            System.out.println("2.Manage Appointment");
            
            System.out.println("Press 0 to Logout from User menu");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
            	case 1:
	            	managePatients(sc);
	                break;    
            	case 2:
            		manageAppointment(sc);
                    break;
                
                case 0:
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    
    public static void managePatients(Scanner sc) {
	       int choice;
	       do {
	           System.out.println("\nWelcome to Patients operation\n");
	           System.out.println(" 1.  Add Details");
	           System.out.println(" 2.  Update Details");
	           
	           System.out.println("Press 0 for returning to Doctor menu");

	           System.out.print("\nEnter your choice: ");
	           choice = sc.nextInt();
	           switch (choice) {
	               case 1:
	                   PatientsOperation.addPatient(sc);
	                   break;
	               case 2:
	            	   PatientsOperation.updatePatient(sc);
	                   break;
	             
	               case 0:
	                   System.out.println("Returning back to Doctors menu.");
	                   break;
	               default:
	                   System.out.println("Invalid choice. Please try again.");
	           }
	       } while (choice != 0);
	   }
    
    
    
    
    
    
    public static void manageAppointment(Scanner sc) {
        int choice;
        do {
            System.out.println("\nWelcome to Appointment\n");
            System.out.println(" 1. Book Appointment");
           System.out.println("  2.  View all tests");
            System.out.println(" 3.  View  all Doctors");
            System.out.println("Press 0 for returning to Doctor menu");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                	AppointmentOperation.bookAppointmet(sc);
                    break;
                case 2:
                	LaboratorieOperation.showlabs(sc);
                    break;
                case 3:
                	DoctorOperation.showDoctors(sc);
                    break;
                
                case 0:
                    System.out.println("Returning back to Doctors menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

	

}
