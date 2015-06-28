package com.mlt.parking.parkingsolution.impl;

import com.mlt.parking.parkingsolution.Vehicle;

public class Car extends Vehicle {

	@Override
	public void park(String slotId) {
		System.out.println(String.format("parked car %s at slotNo %s", registrationNo, slotId));
	}

	@Override
	public void remove(String slotId) {
		System.out.println(String.format("removing car %s from slotId %s", registrationNo, slotId));

	}

}
