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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MileRedeemer {
	private int remainingmiles;
	ArrayList<Destination> destinationList;
	
	MileRedeemer() {
		remainingmiles=0;
		destinationList= new ArrayList<Destination>(); //decalre array list		
	}
	
	public void readDestinations(Scanner fileScanner) {
		String line;
		String[] splitLine;
		String startMonth, endMonth;
		
		while (fileScanner.hasNext()) {
		    line=fileScanner.nextLine();
		    splitLine=line.split(";");
		    startMonth=splitLine[4].split("-")[0];
		    endMonth=splitLine[4].split("-")[1];;
		    destinationList.add(new Destination(splitLine[0], Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(startMonth), Integer.parseInt(endMonth)));
		}
		return;
	}
	
	   public String[] getCityNames() {
		   String[] names = new String[destinationList.size()];
		   for(int i=0;i<destinationList.size();i++)
		     {
		       names[i]=destinationList.get(i).getName();
		     }
		   Arrays.sort(names);
		   return names;
	   }
	   
	   public String[] redeemMiles(int miles, int month) {
		   ArrayList<Destination> redemptionList = new ArrayList<Destination>();
		   ArrayList<String> outputList = new ArrayList<String>();
		   
		   remainingmiles=miles;
		   
		   //find economy tickets we can redeem with our available points
		   Collections.sort(destinationList,new MileageComparator());
		   for(int i=0;i<destinationList.size();i++)
		     {
			   Destination currentDestination = destinationList.get(i);
		       //use flycheap miles if month is within range
			   if (month>=currentDestination.getSmonth() && month<=currentDestination.getEmonth()) {
				   if (currentDestination.getFlyCheapMiles()<=remainingmiles) {
					   redemptionList.add(currentDestination);
					   remainingmiles=remainingmiles-currentDestination.getFlyCheapMiles();
				   }
			   }
			   else {
				   	if (currentDestination.getNormalMiles()<=remainingmiles) {
				   		redemptionList.add(currentDestination);
				   		remainingmiles=remainingmiles-currentDestination.getNormalMiles();
				   }
			   }
			   
		     }
		   
		   
		   //find if we can upgrade any tickets with our available points
		   Collections.sort(redemptionList,new MileageComparator());
		   for(int i=0;i<redemptionList.size();i++) {
			if(redemptionList.get(i).getAdditionalMiles()<=remainingmiles) {
				outputList.add("* A trip to "+redemptionList.get(i).getName()+" in First Class");
				remainingmiles=remainingmiles-redemptionList.get(i).getAdditionalMiles();
			}
			else {
				outputList.add("* A trip to "+redemptionList.get(i).getName()+" in Economy Class");
			}
		   }
		   String[] output = new String[outputList.size()];
		   output = outputList.toArray(output);
		   return output; 		   
	   }
	   
	   public int getRemainingMiles() {
		   return remainingmiles;
	   }
	   
	   public class MileageComparator implements Comparator<Destination> 
	   {
		  @Override 
	      public int compare(Destination d1, Destination d2) 
	      {
	         return (d2.getNormalMiles() - d1.getNormalMiles());
	      }
	   }


}
