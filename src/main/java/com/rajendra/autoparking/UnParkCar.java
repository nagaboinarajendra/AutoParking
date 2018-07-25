
package com.rajendra.autoparking;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;
/**
 * 
 * @author Rajendra_Nagaboina
 *
 */
public class UnParkCar {

	Scanner input = new Scanner(System.in);
	
	public UnParkCar() {
		System.out.print("Enter The Car Number:");
		String carNumber = input.next();
		boolean isCarValid = ParkCar.validate(carNumber);
			if(isCarValid) {
				for(Map.Entry m:ParkCar.slot.entrySet()){  
					   if(m.getValue().equals(carNumber)) {
						   ParkCar.slot.remove(m.getKey());
						   ParkCar.list.add((Integer) m.getKey());
						   
						   long diff = new Date().getTime() - ParkCar.time.get(m.getKey()) ;
						   long diffSeconds = diff / 1000 % 60;
						   long diffMinutes = diff / (60 * 1000) % 60;
						   long diffHours = diff / (60 * 60 * 1000) % 24;
						   long diffDays = diff / (24 * 60 * 60 * 1000);
						   System.out.print("The Vehicle has parked for a duration of ");
						   System.out.print(diffDays + " days, ");
						   System.out.print(diffHours + " hours, ");
						   System.out.print(diffMinutes + " minutes, ");
						   System.out.print(diffSeconds + " seconds.");
						   System.out.println("\nUnparked Successfully!! Thankyou For Using Parking Service");
						   break;
					   } 
				}  
			}
			else {
				System.out.println("Enter a valid car number");
				new UnParkCar();
			}
	}
	
	
}

