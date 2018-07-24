package com.rajendra.autoparking;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParkingSpace {
	
	private static int totalSlots;
	private static int slotsFilled = 0;
	private static int slotsRemaining;
	private String carNumber;
	private static int  slotNumber = 0;
	Hashtable<Integer,String> slot=new Hashtable<Integer,String>();  
	Scanner car =  new Scanner(System.in);
	
	public ParkingSpace(int slots){
		ParkingSpace.totalSlots = slots;
		slotsRemaining = totalSlots;
	}
	
	
	public ParkingSpace() {
		if(slotsRemaining > 0) {
			System.out.print("Enter The Car Number:");
			carNumber = car.next();
			boolean isCarValid = validate(carNumber);
			if(isCarValid) {
				slot.put(slotNumber , carNumber);
				slotNumber++;
				System.out.println("parked successfully");
			}
		}
		else {
			System.out.println("Parking space not available");
		}
	}
	
	public void setRemainingSlots() {
		slotsRemaining = totalSlots - slotsFilled;
	}
	
	public int getReminingSlots() {
		return slotsRemaining;
	}
	
	public boolean validate(String carNumber) {
		if(carNumber.length() == 10) {
			String regex = "^[a-zA-z]{2}[0-9]{2}[a-zA-z]{2}[0-9]{4}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(carNumber);    
			return matcher.matches();
		}
		return true;
	}
	
	
   }

