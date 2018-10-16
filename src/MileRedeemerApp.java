/************************************************************
 *                                                          *
 *  CSCI 470/680          Assignment 4         Summer 2017  *
 *  Team 4                                                  *
 *  Programmers: Vaishnavi Paladugu, Krishna Nallamilli     *
 *  Team Leader: Vaishnavi Paladugu                         *
 *  Date Due:   07/21/2017                                  *                          
 *  Purpose:    This program is find the best flights to    *
 *              to redeem frequent flyer miles on for a     *
 *              traveler.                                   * 
 ***********************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class MileRedeemerApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String fileName;
		Scanner userInput,scanner;
		File file;
		MileRedeemer mr;
		String[] names;
		int miles,month;
		char decision;
		
		do {
		System.out.println("\nPlease enter the name of the file:  ");
		userInput = new Scanner(System.in);
		fileName=userInput.next();
		file = new File(fileName);
		scanner = new Scanner(file);
		mr = new MileRedeemer();
		mr.readDestinations(scanner);
		System.out.println("\n----------------------------------------------------");
	    System.out.println("WELCOME TO THE JAVA AIRLINES MILES  REDEMPTION APP");
	    System.out.println("----------------------------------------------------");
	    System.out.println("\nList of destination cities you can travel to:\n");
	    names = mr.getCityNames();
	    for(int i=0;i<names.length;i++) {
	    	System.out.println(names[i]);
	    }
	    System.out.println("\n---------------------------------------------------\n");
	    System.out.print("Please enter your accumulated Frequent Flyer Miles:  ");
	    miles=userInput.nextInt();
	    System.out.print("\nPlease enter your month of departure(1-12):  ");
	    month=userInput.nextInt();
	    System.out.println("\nYour Frequent Flyer Miles can be used to redeem the following tickets:\n");
	    String[] redemptions = mr.redeemMiles(miles, month);
	    for(int i=0;i<redemptions.length;i++) {
	    	System.out.println(redemptions[i]);
	    }
	    System.out.println("\nYour remaining Frequent Flyer Miles: "+mr.getRemainingMiles());
	    System.out.print("\nDo you want to continue (y/n)? ");
	    decision=userInput.next().charAt(0);
	    
		}while(decision=='y' || decision=='Y');
		
	    System.out.println("\n---------------------------------------------------------");
	    System.out.println("THANK YOU FOR USING THE JAVA AIRLINES MILES REDEMPTION APP");
	    System.out.println("---------------------------------------------------------");
	}

}
