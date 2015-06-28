package com.mlt.parking.parkingsolution;

public interface ParkingSlot {
	
	public String getSlotId();
	
	public boolean isSlotAvailable();
	
	public void unparkVehicle();
	
	public int getDistanceFrom(Entrance e);
	
	public SlotType getType();
}
