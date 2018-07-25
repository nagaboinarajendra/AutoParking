package com.rajendra.autoparking;

import java.util.Date;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;
import java.util.Map;
/**
 * 
 * @author Rajendra_Nagaboina
 *
 */
public class ParkCar {

	String carNumber;
	static Hashtable<Integer,String> slot=new Hashtable<Integer,String>();
	static PriorityQueue<Integer> list=new PriorityQueue<Integer>();  
	static Hashtable<Integer,Long> time=new Hashtable<Integer,Long>();
	Scanner input = new Scanner(System.in);
	
	public ParkCar() {	
		if(ParkingSpace.getReminingSlots() > 0) {
			System.out.print("Enter The Car Number:");
			carNumber = input.next();
			boolean isCarValid = validate(carNumber);
				if(isCarValid) {
					 if(isPresent(carNumber)) {
						 for(Map.Entry m:slot.entrySet()){  
							   if(m.getValue().equals(carNumber)) {
								   System.out.println("Vehicle already parked in Parking Area at slot number" + m.getKey());
							   }  
						} 
						 
					 }
					 else {
						Iterator<Integer> itr2=list.iterator();  		 
						if(itr2.hasNext()) {
							int slotNumber = itr2.next();
							slot.put(slotNumber, carNumber);
							inTime(slotNumber);
							list.remove(slotNumber);
						}
						else {
						slot.put(ParkingSpace.getSlotNumber(), carNumber);
						System.out.println("parked successfully at slot" + ParkingSpace.getSlotNumber());
						inTime(ParkingSpace.getSlotNumber());
						ParkingSpace.setSlotNumber(ParkingSpace.getSlotNumber()+1);
						}
					 }
	
				}
				else {
					System.out.println("Enter a valid car number");
					new ParkCar();
				}
		}
		else {
			System.out.println("Parking space not available");
		}
		
	}
	/**
	 * 
	 * @param carNumber2 is car number
	 * @return true if car number is present
	 */
	private boolean isPresent(String carNumber2) {
		for(Map.Entry m:slot.entrySet()){  
			   if(m.getValue().equals(carNumber2)) {
				   return true;
			   }  
		} 
		return false;
	}
	/**
	 * 
	 * @param carNumber is car number
	 * @return true if it matches with regex
	 */
	public  static boolean validate(String carNumber) {
		int len = carNumber.length();
		if(len == 10) {
			String regex = "^[a-zA-z]{2}[0-9]{2}[a-zA-z]{2}[0-9]{4}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(carNumber);    
			return matcher.matches();
		}
		return false;
	}
	
	public static void inTime(int slot) {   
        time.put(slot,new Date().getTime());
        
	}
	
}

