package com.mlt.parking.parkingsolution.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.mlt.parking.parkingsolution.Entrance;
import com.mlt.parking.parkingsolution.ParkingSlot;
import com.mlt.parking.parkingsolution.SlotType;
import com.mlt.parking.parkingsolution.Vehicle;
import com.mlt.parking.parkingsolution.VehicleType;

public class ParkingControllerTest {
	private List<ParkingSlot> slots;
	private List<Entrance> entrances;
	private ParkingSlot slotCar;
	private ParkingSlot slotBike;
	
	public void init() {

		slots = new ArrayList<>();
		entrances = new ArrayList<>();

		// entrances
		Entrance entranceWest = new EntranceImpl();
		entrances.add(entranceWest);
		Entrance entranceEast = new EntranceImpl();
		entrances.add(entranceEast);
		Entrance entranceNorth = new EntranceImpl();
		entrances.add(entranceNorth);
		Entrance entranceSouth = new EntranceImpl();
		entrances.add(entranceSouth);

		// slot1 - COMPACT
		Map<String, Integer> slot1Distances = new HashMap<>();

		slot1Distances.put(entranceWest.getEntranceId(), 20);
		slot1Distances.put(entranceEast.getEntranceId(), 300);
		slot1Distances.put(entranceNorth.getEntranceId(), 400);
		slot1Distances.put(entranceSouth.getEntranceId(), 600);
		slotCar = new Slot(slot1Distances, SlotType.COMPACT);
		System.out.println("SLOT expected to be assigned for our Car entering from the west gate is " + slotCar.getSlotId());
		//System.out.println("SLOTCar: " + slotCar.getSlotId());
		slots.add(slotCar);

		// slot2 - COMPACT
		Map<String, Integer> slot2Distances = new HashMap<>();

		slot2Distances.put(entranceWest.getEntranceId(), 250);
		slot2Distances.put(entranceEast.getEntranceId(), 350);
		slot2Distances.put(entranceNorth.getEntranceId(), 450);
		slot2Distances.put(entranceSouth.getEntranceId(), 550);
		ParkingSlot slot2 = new Slot(slot2Distances, SlotType.COMPACT);
		slots.add(slot2);
		// slot3 - SEDAN
		Map<String, Integer> slot3Distances = new HashMap<>();

		slot3Distances.put(entranceWest.getEntranceId(), 300);
		slot3Distances.put(entranceEast.getEntranceId(), 400);
		slot3Distances.put(entranceNorth.getEntranceId(), 500);
		slot3Distances.put(entranceSouth.getEntranceId(), 600);
		ParkingSlot slot3 = new Slot(slot3Distances, SlotType.SEDAN);
		slots.add(slot3);

		// slot4 - SEDAN
		Map<String, Integer> slot4Distances = new HashMap<>();

		slot4Distances.put(entranceWest.getEntranceId(), 350);
		slot4Distances.put(entranceEast.getEntranceId(), 450);
		slot4Distances.put(entranceNorth.getEntranceId(), 550);
		slot4Distances.put(entranceSouth.getEntranceId(), 650);
		ParkingSlot slot4 = new Slot(slot4Distances, SlotType.SEDAN);
		slots.add(slot4);

		// slot5 - SEDAN
		Map<String, Integer> slot5Distances = new HashMap<>();

		slot5Distances.put(entranceWest.getEntranceId(), 350);
		slot5Distances.put(entranceEast.getEntranceId(), 450);
		slot5Distances.put(entranceNorth.getEntranceId(), 550);
		slot5Distances.put(entranceSouth.getEntranceId(), 650);
		ParkingSlot slot5 = new Slot(slot5Distances, SlotType.SEDAN);
		slots.add(slot5);

		// slot6 - TWOWHEELER
		Map<String, Integer> slot6Distances = new HashMap<>();

		slot6Distances.put(entranceWest.getEntranceId(), 400);
		slot6Distances.put(entranceEast.getEntranceId(), 500);
		slot6Distances.put(entranceNorth.getEntranceId(), 600);
		slot6Distances.put(entranceSouth.getEntranceId(), 700);
		ParkingSlot slot6 = new Slot(slot6Distances, SlotType.TWOWHEELER);
		slots.add(slot6);

		// slot7 - TWOWHEELER
		Map<String, Integer> slot7Distances = new HashMap<>();

		slot7Distances.put(entranceWest.getEntranceId(), 100);
		slot7Distances.put(entranceEast.getEntranceId(), 200);
		slot7Distances.put(entranceNorth.getEntranceId(), 300);
		slot7Distances.put(entranceSouth.getEntranceId(), 400);
		ParkingSlot slot7 = new Slot(slot7Distances, SlotType.TWOWHEELER);
		slots.add(slot7);

		// slot8 - TWOWHEELER
		Map<String, Integer> slot8Distances = new HashMap<>();

		slot8Distances.put(entranceWest.getEntranceId(), 1000);
		slot8Distances.put(entranceEast.getEntranceId(), 1500);
		slot8Distances.put(entranceNorth.getEntranceId(),1900);
		slot8Distances.put(entranceSouth.getEntranceId(), 25);
		slotBike = new Slot(slot8Distances, SlotType.TWOWHEELER);
		slots.add(slotBike);
		System.out.println("SLOT expected to be assigned for our Bike entering from the south gate is " + slotBike.getSlotId());
	}

	@Test
	public void park() {
		init();
		ParkingController controller  = new ParkingController(slots, entrances);
		Vehicle car = new Car();
		
		car.setType(VehicleType.COMPACT);
		car.setRegistrationNo("CA-798787897");
		
		Token t = controller.park(car, entrances.get(0));
		
		Assert.assertEquals(slotCar.getSlotId(), t.getSlotId().getSlotId());
		
		
		Vehicle bike = new Bike();
		bike.setRegistrationNo("VF-LF-89890890");
		bike.setType(VehicleType.TWOWHEELER);
		Token t1 = controller.park(bike, entrances.get(3));
		Assert.assertEquals(t1.getSlotId().getSlotId(), slotBike.getSlotId());
		
	}

	@Test
	public void removeVehicle() {
		Vehicle car = new Car();
		
		car.setType(VehicleType.SEDAN);
		car.setRegistrationNo("KA-75-L8987");
		ParkingController controller  = new ParkingController(slots, entrances);
		Token t = controller.park(car, entrances.get(1));
		Vehicle parkedVehicle = controller.removeVehicle(t);
		
		Assert.assertEquals(car, parkedVehicle);
	}
}
