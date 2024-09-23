package operation;

import java.util.List;
import java.util.Scanner;

import dao.LaboratoriesDAO;
import model.Labortories;

public class LaboratorieOperation {
	public static void addlab(Scanner sc) {
		System.out.println("Enter TEST ID:");
        int tid = sc.nextInt();
        System.out.println("Enter Test Name:");
        String testName = sc.next();
sc.nextLine();
System.out.println("Enter cost:");
        int price = sc.nextInt();

        // Creating object of  class
        Labortories obj = new Labortories(tid,testName ,price);

        // Calling method to insert into table and passing the object of Labortories class
        boolean result = LaboratoriesDAO.insert(obj);
        if (result) {
            System.out.println("The Test is successfully added.");
        } else {
            System.out.println("Something went wrong.");
        }
    }
    public static void showlabs(Scanner sc) {
        // Get all 
        List<Labortories> labortoriess = LaboratoriesDAO.getAlllabs();
        for (Labortories labortories : labortoriess) {
            System.out.println(labortories);
        }
    }

    

    public static void deletelabByName(Scanner sc) {
        System.out.println("Enter Tests Name to delete:");
        String testName = sc.next();

        // Calling method to delete a particular record
        boolean result = LaboratoriesDAO.delete(testName);
        if (result) {
            System.out.println("The Laboratories is successfully deleted.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

}
