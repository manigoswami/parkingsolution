package com.mlt.parking.parkingsolution.impl;

import java.util.UUID;

import com.mlt.parking.parkingsolution.Entrance;
import com.mlt.parking.parkingsolution.ParkingSlot;

public class EntranceImpl extends Entrance {
	private String id;

	public EntranceImpl() {
		id = UUID.randomUUID().toString();
	}

	@Override
	public String getEntranceId() {
		return id;
	}

	@Override
	public int getDistance(ParkingSlot slot) {
		return 0;
	}


	public int compare(ParkingSlot p1, ParkingSlot p2) {
		if (p1.getDistanceFrom(this) > p2.getDistanceFrom(this)) {
			return 1;
		}
		return -1;
	}

}
