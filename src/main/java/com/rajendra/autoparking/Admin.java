package com.rajendra.autoparking;

import java.util.Map;
import java.util.Scanner;
/**
 * 
 * @author Rajendra_Nagaboina
 *
 */
public class Admin {
	final String username = "rajendra";
	final String password = "1234";
	boolean adminLogin = true;
	Scanner adminCredentials = new Scanner(System.in);
	public Admin(){
		System.out.print("USERNAME:");
		String adminUsername = adminCredentials.next();
		System.out.print("\nPASSWORD:");
		String adminPassword = adminCredentials.next();
			if( validateAdmin(adminUsername,adminPassword)) {
					while(adminLogin) {
					System.out.println("Select one of the following:\n1.park the car\n2.Unpark the car\n3.exit\n4.display");
					int choice = adminCredentials.nextInt();
					switch(choice) {
					case 1: new ParkCar();
							break;
					case 2: new UnParkCar();
							break;
					case 3: adminLogin = false;
							System.out.println("Thankyou for visiting!!!");
							break;
					case 4: display();
					}
					}
			}
			else {
				System.out.println("The entered credentials are incorrect!!\n Please enter the correct credentials!");
				new Admin();
			}
	}
	/**
	 * displays parking space 
	 */
	private void display() {
		
		 for(Map.Entry m:ParkCar.slot.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  
			  }  
		
	}
	/**
	 * 
	 * @param username of admin
	 * @param password of admin
	 * @return
	 */
	public boolean validateAdmin(String username, String password) {
		if( this.username.equals(username) && this.password.equals(password)) {
			return true; 
		}
		return false;
	}
	
}
