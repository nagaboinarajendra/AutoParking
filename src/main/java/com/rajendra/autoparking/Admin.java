package com.rajendra.autoparking;

import java.util.Scanner;

public class Admin {
	
	final String username = "rajendra";
	final String password = "1234";
	Scanner adminCredentials = new Scanner(System.in);
	
	public Admin(){
		System.out.print("USERNAME:");
		String adminUsername = adminCredentials.next();
		System.out.print("\nPASSWORD:");
		String adminPassword = adminCredentials.next();
		
		System.out.println(adminUsername + adminPassword);
		
		if( adminUsername.equals(username) && adminPassword.equals(password)) {
			System.out.println("Select one of the following:\n1.park the car\n2.Unpark the car");
			int choice = adminCredentials.nextInt();
			switch(choice) {
			case 1: new ParkCar();
					break;
			case 2: new UnParkCar();
					break;
			default:
			
			}
		}
		else {
			System.out.println("The entered credentials are incorrect!!\n Please enter the correct credentials!");
			new Admin();
		}
	}
	
}
