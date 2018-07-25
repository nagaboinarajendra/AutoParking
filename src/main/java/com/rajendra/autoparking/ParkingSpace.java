package com.rajendra.autoparking;

/**
 * 
 * @author Rajendra_Nagaboina
 *
 */
public class ParkingSpace {
	
	private static int totalSlots;
	private static int slotsFilled = 0;
	private static int slotsRemaining;
	private static int slotNumber =1;
	/**
	 * 
	 * @param slot parking slot of vehicle
	 */
	public ParkingSpace(int slot){
		ParkingSpace.totalSlots = slot;
		slotsRemaining = totalSlots;
	}
		
	public static void setRemainingSlots() {
		slotsRemaining = totalSlots - slotsFilled;
	}
	/**
	 * 
	 * @return number of slots remaining
	 */
	public static int getReminingSlots() {
		return slotsRemaining;
	}
	/**
	 * 
	 * @return slot number of Vehicle
	 */
	public static int getSlotNumber() {
		return slotNumber;
	}
	/**
	 * 
	 * @param slotNumber of the vehicle
	 */
	public static void setSlotNumber(int slotNumber) {
		ParkingSpace.slotNumber = slotNumber;
	}

	
   }

