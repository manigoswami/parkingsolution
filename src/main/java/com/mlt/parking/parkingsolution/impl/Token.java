package com.mlt.parking.parkingsolution.impl;

import java.util.UUID;

import com.mlt.parking.parkingsolution.ParkingSlot;
import com.mlt.parking.parkingsolution.Vehicle;

public class Token {
	private String tokenId;
	private ParkingSlot slot;
	private Vehicle vehicle;
	
	public Token() {
		tokenId = UUID.randomUUID().toString();
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public ParkingSlot getSlotId() {
		return slot;
	}
	public Token setSlotId(ParkingSlot slot) {
		this.slot = slot;
		return this;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public Token setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}
}
