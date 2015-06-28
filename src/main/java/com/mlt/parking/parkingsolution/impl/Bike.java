package com.mlt.parking.parkingsolution.impl;

import com.mlt.parking.parkingsolution.Vehicle;

public class Bike extends Vehicle {

	@Override
	public void park(String slotId) {
		System.out.println(String.format("parked bike %s at slotNo %s", registrationNo, slotId));

	}

	@Override
	public void remove(String slotId) {
		System.out.println(String.format("parked bike %s at slotNo %s", registrationNo, slotId));

	}

}
