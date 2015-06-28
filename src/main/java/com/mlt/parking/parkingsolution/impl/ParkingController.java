package com.mlt.parking.parkingsolution.impl;

import java.util.List;

import com.mlt.parking.parkingsolution.Entrance;
import com.mlt.parking.parkingsolution.ParkingSlot;
import com.mlt.parking.parkingsolution.Vehicle;

/**
 * ParkingController acts as an interface
 * for the Parking System
 * 
 * 1. It requires setting in the infrastructure details
 *    like parking slots, entrances etc. in required format
 * 2. It allow one to park a vehicle, by specifying the vehicle
 *    and entrance
 * 3. For removing a vehicle, the token presented during parking
 *    should be presented. It returns the vehicle back
 *  
 * @ToDo: Current implementation does not take care of few things:
 *        like fare management, queuing/waiting for vehicle when
 *        all slots are filled etc 
 * 
 * @author mgoswami
 *
 */
public class ParkingController {

	private List<ParkingSlot> slots;
	private List<Entrance> entrances;
	private ParkingManager parkingManager;

	/*
	 * load all the parking infrastructure details. In real life, this will be
	 * loaded from DB
	 */
	public ParkingController(List<ParkingSlot> slots, List<Entrance> entrances) {
		this.slots = slots;
		this.entrances = entrances;
		parkingManager = new ParkingManager(slots, entrances);
	}

	public Token park(Vehicle v, Entrance e) {
		return parkingManager.parkVehicle(e, v);
	}
	
	public Vehicle removeVehicle(Token t){
		return parkingManager.unparkVehicle(t);
	}

}
