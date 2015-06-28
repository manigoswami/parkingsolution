package com.mlt.parking.parkingsolution.impl;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import com.mlt.parking.parkingsolution.Entrance;
import com.mlt.parking.parkingsolution.ParkingSlot;
import com.mlt.parking.parkingsolution.Vehicle;
import com.mlt.parking.parkingsolution.VehicleType;

public class ParkingManager {
	private List<Entrance> entrances;
	private List<ParkingSlot> parkingSlots;
	private Map<Entrance, Map<VehicleType, SortedSet<ParkingSlot>>> availableSlots;

	public ParkingManager(List<ParkingSlot> slots, List<Entrance> entrances) {
		availableSlots = new HashMap<>();
		List<VehicleType> vehicleList = new ArrayList<VehicleType>(
				EnumSet.allOf(VehicleType.class));
		this.entrances = entrances;
		parkingSlots = slots;

		for (Entrance e : entrances) {
			Map<VehicleType, SortedSet<ParkingSlot>> vMap = new HashMap<>();

			for (VehicleType v : vehicleList) {
				SortedSet<ParkingSlot> sortedSlots = new TreeSet<ParkingSlot>(e);

				for (ParkingSlot s : parkingSlots) {
					// add only if slot can accommodate the vehicle type
					if (s.getType().compareTo(s.getType()) == 0) {
						sortedSlots.add(s);
					}
				}
				vMap.put(v, sortedSlots);
			}
			availableSlots.put(e, vMap);
		}

	}

	public ParkingSlot getNearestSlot(Entrance entrance, Vehicle vehicle) {
		return availableSlots.get(entrance).get(vehicle.getType()).first();
	}

	public Token parkVehicle(Entrance entrance, Vehicle vehicle) {
		ParkingSlot slot = getNearestSlot(entrance, vehicle);

		Iterator<Entrance> eIterator = entrances.iterator();
		while (eIterator.hasNext()) {

			Iterator<ParkingSlot> iterator = availableSlots
					.get(eIterator.next()).get(vehicle.getType()).iterator();

			while (iterator.hasNext()) {
				if (slot.getSlotId().compareTo(iterator.next().getSlotId()) == 0) {
					iterator.remove();
					break;
				}
			}
		}
		//finally park the vehicle
		vehicle.park(slot.getSlotId());
		
		//return a token
		Token token = new Token();
		return token.setSlotId(slot).setVehicle(vehicle);

	}

	public Vehicle unparkVehicle(Token token) {
		ParkingSlot slot = token.getSlotId();
		Vehicle vehicle = token.getVehicle();
		Iterator<Entrance> eIterator = entrances.iterator();
		while (eIterator.hasNext()) {
			availableSlots.get(eIterator.next()).get(vehicle.getType())
					.add(slot);
		}
		vehicle.remove(slot.getSlotId());
		return vehicle;
	}

}
