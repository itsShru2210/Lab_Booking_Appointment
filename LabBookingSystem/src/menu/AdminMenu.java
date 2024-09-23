package menu;

import java.util.Scanner;


import operation.DoctorOperation;

import operation.LaboratorieOperation;
import operation.PatientsOperation;



public class AdminMenu {

	// Admin menu
	   public static void adminMenu(Scanner sc) {
	       int choice;
	       do {
	           System.out.println("\nWelcome to Admin Page\n");
	           System.out.println(" 1.Manage Doctor");
	           System.out.println(" 2.Manage Patients");
	          
	           System.out.println(" 3.Manage Laboratories");
	           
	           System.out.println("0.to Logout from Admin menu");
	           
	           System.out.print("\nEnter your choice: ");
	           choice = sc.nextInt();
	           switch (choice) {
	               case 1:
	                   manageDoctors(sc);
	                   break;
	               case 2:
	                   managePatients(sc);
	                   break;
	              
	               case 3:
	                   manageLaboratories(sc);
	                   break;
	             
	               case 0:
	                   System.out.println("Logged out successfully from Admin page.");
	                   break;
	               default:
	                   System.out.println("Invalid choice. Please try again.");
	           }
	       } while (choice != 0);
	   }

	   public static void manageDoctors(Scanner sc) {
	       int choice;
	       do {
	           System.out.println("\nWelcome Admin\n");
	           System.out.println(" 1. Add a Doctor");
	           System.out.println(" 2. Delete A Doctor by Id");
	           System.out.println(" 3. View all Doctors");
	           
	           System.out.println("Press 0 for returning to admin menu");

	           System.out.print("\nEnter your choice: ");
	           choice = sc.nextInt();
	           switch (choice) {
	               case 1:
	                   DoctorOperation.addDoctor(sc);
	                   break;
	               case 2:
	            	   DoctorOperation.deleteDoctorById(sc);
	                   break;
	               case 3:
	            	   DoctorOperation.showDoctors(sc);
	                   break;
	               
	               case 0:
	                   System.out.println("Returning back to admin menu.");
	                   break;
	               default:
	                   System.out.println("Invalid choice. Please try again.");
	           }
	       } while (choice != 0);
	   }

	   public static void managePatients(Scanner sc) {
	       int choice;
	       do {
	           System.out.println("\nWelcome to Patientsoperation\n");
	           System.out.println(" 1.  Add Patients");
	           System.out.println(" 2.  Update an Patients");
	           System.out.println(" 3.  View all Patients");
	           System.out.println("4.  View Patients by Id");
	           
	           System.out.println("Press 0 for returning to admin menu");

	           System.out.print("\nEnter your choice: ");
	           choice = sc.nextInt();
	           switch (choice) {
	               case 1:
	                   PatientsOperation.addPatient(sc);
	                   break;
	               case 2:
	            	   PatientsOperation.updatePatient(sc);
	                   break;
	               case 3:
	            	   PatientsOperation.showPatients(sc);
	                   break;
	               case 4:
	            	   PatientsOperation.showPatientById(sc);
	                   break;
	               
	               case 0:
	                   System.out.println("Returning back to admin menu.");
	                   break;
	               default:
	                   System.out.println("Invalid choice. Please try again.");
	           }
	       } while (choice != 0);
	   }

	   	   public static void manageLaboratories(Scanner sc) {
	       int choice;
	       do {
	           System.out.println("\nWelcome to Laboratories operation\n");
	           System.out.println(" 1.  Add a Laboratories");
	          
	           System.out.println(" 2. View all Laboratories");
	           System.out.println(" 3. Delete Laboratories");
	           
	           System.out.println("Press 0 for returning to admin menu");

	           System.out.print("\nEnter your choice: ");
	           choice = sc.nextInt();
	           switch (choice) {
	               case 1:
	            	   LaboratorieOperation.addlab(sc);
	                   break;
	               case 2:
	            	   LaboratorieOperation.showlabs(sc);
	                   break;
	               case 3:
	            	   LaboratorieOperation.deletelabByName(sc);
	                   break;
	             
	               case 0:
	                   System.out.println("Returning back to admin menu.");
	                   break;
	               default:
	                   System.out.println("Invalid choice. Please try again.");
	           }
	       } while (choice != 0);
	   }

	   
}
