package com.mlt.parking.parkingsolution.impl;

import com.mlt.parking.parkingsolution.Vehicle;

public class ParkingDetail {
	private String slotId;
	private String entranceId;
	private Vehicle vehicle;
	public String getSlotId() {
		return slotId;
	}
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	public String getEntranceId() {
		return entranceId;
	}
	public void setEntranceId(String entranceId) {
		this.entranceId = entranceId;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
