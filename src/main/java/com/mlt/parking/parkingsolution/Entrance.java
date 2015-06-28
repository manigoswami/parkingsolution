package com.mlt.parking.parkingsolution;

import java.util.Comparator;

public abstract class Entrance implements Comparator<ParkingSlot>{
	public abstract String getEntranceId();
	
	public abstract int getDistance(ParkingSlot slot);
}
