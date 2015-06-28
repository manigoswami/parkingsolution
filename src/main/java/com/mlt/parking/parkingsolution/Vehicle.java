package com.mlt.parking.parkingsolution;

public abstract class Vehicle {
	protected VehicleType type;
	protected String registrationNo;

	public abstract void park(String slotId);

	public abstract void remove(String slotId);

	public void setType(VehicleType type) {
		this.type = type;

	}

	public VehicleType getType() {
		return type;
	}
	
	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
}
