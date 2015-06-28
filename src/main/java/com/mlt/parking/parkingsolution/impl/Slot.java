package com.mlt.parking.parkingsolution.impl;

import java.util.Map;
import java.util.UUID;

import com.mlt.parking.parkingsolution.Entrance;
import com.mlt.parking.parkingsolution.ParkingSlot;
import com.mlt.parking.parkingsolution.SlotType;
import com.mlt.parking.parkingsolution.VehicleType;

public class Slot implements ParkingSlot, Comparable<VehicleType> {

	private String slotId;
	private SlotType type;
	private boolean isSlotAvailable = false;
	private Map<String, Integer> distanceFromEntrance;

	public Slot(Map<String, Integer> distances, SlotType type) {
		slotId = UUID.randomUUID().toString();
		distanceFromEntrance = distances;
		this.type = type;
	}

	@Override
	public String getSlotId() {
		return slotId;
	}

	@Override
	public boolean isSlotAvailable() {
		return this.isSlotAvailable;
	}

	@Override
	public void unparkVehicle() {
		this.isSlotAvailable = true;
		this.type = null;
	}

	@Override
	public int getDistanceFrom(Entrance e) {
		return distanceFromEntrance.get(e.getEntranceId());
	}

	@Override
	public SlotType getType() {

		return type;
	}

	@Override
	public int compareTo(VehicleType v) {
		if (v.toString() == type.toString()){
			return 0;
		}
		return -1;
	}

}
